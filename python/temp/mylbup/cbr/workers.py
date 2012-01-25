#!/usr/bin/python2.6
import ConfigParser


parser=ConfigParser.RawConfigParser()
parser.readfp(open("workers.cfg"))

workers={}

for workername in parser.sections():
	workers[workername] = {}
	for item in parser.items(workername):
		workers[workername][item[0]]= item[1]

print workers
