#!/usr/bin/python2.6
 
from xml.dom import minidom

datafile = open("people.xml")
dom = minidom.parse(datafile)

people = dom.getElementsByTagName("people")[0]
persons = people.getElementsByTagName("person")
for person in persons :
	print "\nName:%s\nEmployer:%s\nResidence:%s"%(person.getElementsByTagName("name")[0].firstChild.data, person.getElementsByTagName("employer")[0].firstChild.data,person.getElementsByTagName("residence")[0].firstChild.data)

