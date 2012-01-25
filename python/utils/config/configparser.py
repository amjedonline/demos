#!/usr/bin/python2.6

import ConfigParser

config = ConfigParser.RawConfigParser()

config.add_section("Personal")
config.set('Personal','name',"Mohd Amjed")
config.set('Personal','age','23')
config.set('Personal','gender','male')

config.add_section("Professional")
config.set("Professional","profession","Software Developer")


with open("/home/amjed/Desktop/example.cfg","wb") as configfile:
	config.write(configfile)
