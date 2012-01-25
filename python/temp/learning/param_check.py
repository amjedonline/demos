#!/usr/bin/python2.6

def check_param(param1):
	if type(param1) != type(0) and type(param1) != type(""):
		# It is neither integer, nor a string
		raise TypeError, "%s ought to be either an integer or a string" %param1

check_param(1)
check_param({})
