#!/usr/bin/python

import cgi
import cgitb
import os
import re

from bittywiki import Wiki, Page, NotWikiWord
cgitb.enable()

#First, some HTML Templates.
MAIN_TEMPLATE = '''<html>
<head><title>%(title)s</title>
<body>%(body)s<hr/>%(navLinks)s</body>
</html>'''

VIEW_TEMPLATE = '''%(banner)s
<h1>%(name)s</h1>
%(processedText)s'''

WRITE_TEMPLATE = '''%(banner)s
<h1>%(title)s</h1>
<form method ="POST" action="%(pageURL)s">
 <input type="hidden" name="operation" value="write">
 <textarea rows="15" cols="80" name="data">%(text)s</textarea><br/>
 <input type="submit" value="Save">
</form>'''

DELETE_TEMPLATE = '''<h1>%(title)s</h1>
<p>Are you sure %(name)s is the page you want to delete?</p>

<form method="POST" action"%(pageURL)s">
 <input type="hidden" name="operation" value="delete">
 <input type="submit" value="Delete %(name)s!">
</form>'''

ERROR_TEMPLATE = '<h1>Error: %(error)s</h1>'
BANNER_TEMPLATE = '<p style="color:red;">%s</p><hr/>'


#A snippet for linking a WikiWord to the corresponding wiki page.
VIEW_LINK = '<a href="%s">%%(wikiword)s</a>'

#A snippet for linking a wikiword with not corresponding page to a 
#form for creating that page
ADD_LINK = '%%(wikiword)s<a href="%s">?</a>'


class WikiCGI:
	#The possible operations on a wiki page.
	VIEW = ''
	WRITE = 'write'
	DELETE = 'delete'

	def __init__(self, wikiRoot):
		self.wiki = Wiki(wikiRoot)

	def run(self):
		toDisplay = None
		try:
			#Retrieve the wiki page the user wants.
			page = os.environ.get('PATH_INFO', '')
			if page:
				page = page[1:]
			page = self.wiki.getPage(page)
		except NotWikiWord, badName:
			page = None
			error = '"%s" is not a valid wiki page name.'%badName
			toDisplay = self.makeError(error)
		if page:
			#Determine what the user wants to do witht he page they requested
			makeChange = os.environ['REQUEST_METHOD'] == 'POST'
			if makeChange:
				defaultOperation = self.WRITE
			else:
				defaultOperation = ''
			form = cgi.FieldStorage()
			operation = form.getfirst('operation', defaultOperation)
					
			#We know resource and action, now delegate to apt method, the action requested
			operationMethod = self.OPERATION_METHODS.get(operation)
			if not operationMethod:
				error = '"%s" is not a valid operation.' % operation
				toDisplay = self.makeError(error)
			if not page.exists() and operation and not \
   				(makeChange and operation == self.WRITE):
				toDisplay = self.makeError('No such page: "%s"' % page.name)
			if operationMethod:
				toDisplay = operationMethod(self, page, makeChange, form)
			
			# all the operation methods return these
			title, bodyTemplate, bodyArgs, navLinks = toDisplay
			if page and page.name != Wiki.HOME_PAGE_NAME:
				backLink = '<a href="%s">Back to wiki homepage</a>'
				navLinks.append(backLink%self.makeURL())
			print "Content-type:text/html\n"
			print MAIN_TEMPLATE % {'title': title, 'body':bodyTemplate %bodyArgs,'navLinks':' | '.join(navLinks)}


	def viewOperation(self, page, makeChange, form=None, banner=None):
		if banner:
			banner = BANNER_TEMPLATE %banner
		else:
			banner = '';
		if not page.exists():
			title = 'Creating %s'%page.name
			toDisplay = (title, WRITE_TEMPLATE, {'title':title, 'banner':banner, \
						'pageURL': self.makeURL(page),
						'text': ''}, [] )
		else :
			writeLink = '<a href="%s">Edit this page</a>' % self.makeURL(page, self.WRITE)
			deleteLink = '<a href="%s">Delete this page</a>' % self.makeURL(page, self.DELETE)
			toDisplay = (page.name, VIEW_TEMPLATE,
					{
						'name' : page.name,
						'banner' : banner,
 						'processedText' : self.renderPage(page)
					},
					[writeLink, deleteLink]
					)
		return toDisplay

	def writeOperation(self, page, makeChange, form):
		if makeChange:
			data = form.getfirst('data')
			page.text = data
			page.save()
			#The operation is done, but we still need a document to
			#return to the user. Display the new version of this page,
			#with a banner.
			toDisplay = self.viewOperation(page, 0, banner='Page saved.')
		else:
			navLinks = []
			pageURL = self.makeURL(page)
			if page.exists():
				title = 'Editing ' + page.name
				navLinks.append('<a href="%s">Back to %s</a>' % (pageURL,
			                                                          page.name))
			else:
				title = 'Creating ' + page.name
			toDisplay = (title, WRITE_TEMPLATE, {'title' : title,
			                                         'banner' : '',
			                                         'pageURL' : pageURL,
			                                         'text' : page.getText()},
			                  			navLinks)
		return toDisplay


	def deleteOperation(self, page, makeChange, form=None):
		"Deletes a page, or displays its delete form."
		if makeChange:
			page.delete()
			banner = 'Page "%s" deleted.' % page.name
			#The page is deleted, but we still need a document to
			#return to the user. Display the wiki homepage, with a banner.
			toDisplay = self.viewOperation(self.wiki.getPage(), 0,
				banner=banner)
		else:
			if page.exists():
				title = 'Deleting ' + page.name
				pageURL = self.makeURL(page)
				backLink = '<a href="%s">Back to %s</a>'
				toDisplay = (title, DELETE_TEMPLATE, {'title' : title,
					'name' : page.name,
					'pageURL' : pageURL},
						[backLink % (pageURL, page.name)])
			else:
				error = "You can't delete a page that doesn't exist."
				toDisplay = self.makeError(error)
		return toDisplay

	#A registry mapping 'operation' keys to methods that perform the operations.
	OPERATION_METHODS = { VIEW : viewOperation,
		WRITE: writeOperation,
		DELETE: deleteOperation }

	def makeError(self, errorMessage):
		"Creates a set of return values indicating an error."
		return (ERROR_TEMPLATE, "Error", {'error' : errorMessage,
			'mainURL' : self.makeURL("")}, [])
	
	def makeURL(self, page="", operation=None):
		if (hasattr(page, "name")):
			page = page.name
		url = os.environ['SCRIPT_NAME'] + '/' + page
		if operation:
			url = url + '?operation=' + operation
		return url

	#A regular expression for use in turning multiple newlines
	#into paragraph breaks.
	MULTIPLE_NEWLINES = re.compile("(\r?\n){2,}")
	
	def renderPage(self, page):
		text = page.getText()
		for find, replace in ( ('<','&lt;'), ('>','&gt;'), ('&', '&amp;') ):
			text.replace(find, replace)
		html = '<p>' + page.WIKI_WORD.sub(self._linkWikiWord, text) +'</p>'
		html = self.MULTIPLE_NEWLINES.sub('<p>\n</p>',html)
		return html

	def _linkWikiWord(self, match):
		linkedPage = self.wiki.getPage(match.group(0))
		link = ADD_LINK
		if linkedPage.exists():
			link = VIEW_LINK
		link = link % self.makeURL("%(wikiword)s")
		return link % {'wikiword':linkedPage.name}



if __name__ == "__main__":
	WikiCGI("/home/amjed/wiki/").run()
