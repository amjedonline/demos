#!/usr/bin/python2.6


def capitalize(t):
	res=[]
	for element in t:
		res.append(element.capitalize())
	return res

breakfast=["coffee","egg","bread"]

print capitalize(breakfast)

# Operations on list of numbers

print "Demonstrating various operations on list of numbers"
numbers=[123,2451,65221,5623,25,5,21,3452,7,87,4562,124,45,6752,123,87,25,25,65243]
print "Original numbers %s"%numbers

print "sum of list of numbers: sum(list) : %s"%sum(numbers)

numbers.sort()
print "Sorted list of numbers, this is inplace %s"%numbers

numbers.reverse()
print "reverse the list of numbers %s"%numbers

print "Count the number of occurences of a particular element %s"%numbers.count(25)
