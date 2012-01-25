#!/bin/sh

count=1
while [ $count -lt 6 ]; do
	innerCount=1
	string=""
	while [ $innerCount -lt $count ]; do
		string=$string$innerCount
		innerCount=$(($innerCount+1))
	done
	echo $string
	count=$(($count+1))
done
	
