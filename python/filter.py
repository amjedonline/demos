#!/usr/bin/python2.6

# filter method in python take a callback function and a sequence, and returns only the elements in the list which are filtered through the passed callback method. The callback method must either return true or false for each element.

print filter((lambda f: f%2==0), [1,2,3,4,5,6,7,8,9,0])

