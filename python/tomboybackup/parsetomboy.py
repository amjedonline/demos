from xml.dom.minidom import parse
import xml.dom
import os
import re

NS_LINK = "http://beatniksoftware.com/tomboy/link"
NS_SIZE = "http://beatniksoftware.com/tomboy/size"
NS_TOMBOY = "http://beatniksoftware.com/tomboy"

TOMBOY_DATA_DIR = "/home/amjed/.local/share/tomboy"
EXPORT_LOCATION = "/home/amjed/mybackups/tomboy/"

def getHTMLForNote(document):
	note = document.getElementsByTagName("note")[0]
	#title
	title = note.getElementsByTagName("title")[0].childNodes[0].data
	
	#text/note-content
	text = "empty"
	text = note.getElementsByTagName("text")[0]
	noteContent = ""
	if text.getElementsByTagName("note-content").length > 0 and text.getElementsByTagName("note-content")[0].childNodes.length > 0 and hasattr(text.getElementsByTagName("note-content")[0].childNodes[0], "data") :
		noteContent = text.getElementsByTagName("note-content")[0].childNodes[0].data
	html = "<html><head><title>%s</title></head><body><pre>%s</pre></body></html>" %(title, noteContent)
	return html

def exportToHtml(document):
	note = document.getElementsByTagName("note")[0]

	title = note.getElementsByTagName("title")[0].childNodes[0].data

	#Create note book with tag name, tag name by default is uncategorized
	tag = "uncategorized"
	tags = document.getElementsByTagName("tags")
	if tags.length > 0:
		tagIndex = 0;
		#while tagIndex< tags.length:
			#tagIndex++
		if tags[0].getElementsByTagName("tag").length > 0 and tags[0].getElementsByTagName("tag")[0].childNodes.length > 0 and hasattr(tags[0].getElementsByTagName("tag")[0].childNodes[0],"data"):
			tag = tags[0].getElementsByTagName("tag")[0].childNodes[tagIndex].data
			tag = tag.split(":")[-1]
	print "Got this tag: %s" %tag
	tagDir = os.path.join(EXPORT_LOCATION, tag)
	if not os.path.isdir(tagDir):
		print "Trying to create directory %s" %tagDir
		os.makedirs(tagDir)

	fileName = re.sub("[^a-zA-Z0-9]+", "-",title)
	fileName = fileName+".html"
	print "Exporting %s" %fileName
	noteHTMLFile = open(os.path.join(tagDir, fileName), "w")
	html = getHTMLForNote(document)
	try:
		noteHTMLFile.write(html)
	except Exception, e:
		print "Error occurred: %s" %e
		print "This is the file content, am trying to write:\n%s "%html
		print "This char : %s" %html[71]
	noteHTMLFile.close()
		
if __name__ == "__main__":
	files = os.listdir(TOMBOY_DATA_DIR)
	for file in files: 
		file = os.path.join(TOMBOY_DATA_DIR,file)
		if os.path.isfile(file):
			noteDoc = parse(file)
			exportToHtml(noteDoc) 
