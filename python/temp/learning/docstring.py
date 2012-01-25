#!/usr/bin/python2.6

def in_fridge():
	"""This is a docstring """
	try:
		count=fridge[wanted_food]
	except KeyError:
		count = 0
	return count


print "%s" % in_fridge.__doc__
