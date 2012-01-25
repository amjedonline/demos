#!/usr/bin/python2.6

from HTMLParser import HTMLParser

class HeadingParser(HTMLParser):
	inHeading = False
	
	def handle_starttag(self, tag, attrs):
		if tag == "h1":
			self.inHeading = True

	def handle_endtag(self, tag):
		if tag == "h1":
			self.inHeading = False

	def handle_data(self, data):
		if self.inHeading:
			print data

if __name__ == "__main__":
	file = open("sample.html", "r")
	html = file.read()
	hparser = HeadingParser()
	file.close()
	hparser.feed(html)
