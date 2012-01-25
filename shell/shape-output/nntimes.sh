#!/bin/sh

count=1
while [ $count -lt 6 ]; do
	innerCount=0;
	string=""
	while [ $innerCount -lt $count ]; do 
		string=$string$count;
		innerCount=$(($innerCount+1))
	done
	count=$(($count+1))
	echo $string
done

	
