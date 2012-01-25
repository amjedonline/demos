#!/bin/python

from HTMLParser import HTMLParser

class HeadingParser(HTMLParser):
	inHeading = False

	def handle_starttag(self, tag, attrs):
		if tag == "h1":
			self.inHeading = True
			print "Found a Heading 1"

	def handle_data(self, data):
		if self.inHeading:
			print data
	
	def handle_endtag(self, tag):
		if tag == "h1":
			self.inHeading = False

hParser = HeadingParser()
import urllib
yahoo = urllib.urlopen("http://www.yahoo.com")
html = yahoo.read()
#file = open("headings.html","r")
#html = file.read()
#file.close()
hParser.feed(html)

	
