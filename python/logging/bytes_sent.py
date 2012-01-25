#!/usr/bin/python2.6

import sys

logfile=open("access-log.txt","r")
count = 0
for line in logfile:
	try:
		number = int(line.split()[9])
	except ValueError:
		#totally disregard anything we dont understand
		continue
	count = count + number
print count
