import os
import sys

file=open("data.csv","r");
contents = file.read()
print contents

lines=contents.split("\n")
for line in lines:
	fields = line.split(",")
	print "statementdate:",fields[0]
	print "end date:",fields[1]
  	print "previous:",fields[2]
   	print "current:", fields[3]
   	print "interest & other charges:",fields[4]

