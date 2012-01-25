#!/usr/bin/python2.6

def in_fridge():
	"""This is a docstring """
	try:
		count=fridge[wanted_food]
	except KeyError:
		count = 0
	return count

fridge = {"apples":10, "oranges":3, "milk":2}
wanted_food = "apples"

#print in_fridge()

def in_fridge(some_fridge, desired_item):
	"""This is a function to see if the fridge has a food."""
	try:
		count = some_fridge[desired_item]
	except KeyError:
		count = 0
	return count

print in_fridge(fridge, wanted_food)
