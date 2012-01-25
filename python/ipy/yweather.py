#!/usr/bin/python2.6

import urllib
from xml.dom import minidom

WEATHER_URL = 'http://xml.weather.yahoo.com/forecastrss?p=%s'
WEATHER_NS = 'http://xml.weather.yahoo.com/ns/rss/1.0'


url = WEATHER_URL %"98101"
#print urllib.urlopen(url).read()

def weather_for_zip(zip=None):
	url = WEATHER_URL %zip
	dom = minidom.parse(urllib.urlopen(url))
	forecasts = []
	for node in dom.getElementsByTagNameNS(WEATHER_NS,"forecast"):
		forecasts.append({'date':node.getAttribute('date'),
				'low':node.getAttribute('low'),
				'high':node.getAttribute('high'),
				'condition':node.getAttribute('text')})

	ycondition = dom.getElementsByTagNameNS(WEATHER_NS, "condition")[0]
	return {
		'current_condition':ycondition.getAttribute('text'),
		'current_temp':ycondition.getAttribute('temp'),
		'forecast':forecasts,
		'title':dom.getElementsByTagName('title')[0].firstChild.data }
print weather_for_zip("98101")

