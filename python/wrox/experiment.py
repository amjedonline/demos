#!/bin/python

from HTMLParser import HTMLParser
import sys

class HeadingParser(HTMLParser):
	inQuestion = False 

	def handle_starttag(self, tag, attrs):
		if tag == "div" and  attrs.__contains__(("class","post-text")):
			self.inQuestion = True

	def handle_data(self, data):
		if self.inQuestion:
			print data
	
	def handle_endtag(self, tag):
		if tag == "div" and self.inQuestion == True:
			self.inQuestion = False
	
hParser = HeadingParser()
import urllib
yahoo = urllib.urlopen("http://stackoverflow.com/questions/1872965/get-vs-post-in-ajax")
html = yahoo.read()
#file = open("headings.html","r")
#html = file.read()
#file.close()
hParser.feed(html)

	
