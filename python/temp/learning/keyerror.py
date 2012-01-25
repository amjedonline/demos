#!/usr/bin/python2.6

breakfast = {"egg":10,"peppers":3,"cheese":5,"milk":3,"mushroom":6}
try:
	if breakfast["orange juice"] > 0:
		print "We have orange juice"
	else:
		print "There is no more orange juice"
except KeyError, error:
	print "Aww, we never procured %s, lets go shopping" %error


