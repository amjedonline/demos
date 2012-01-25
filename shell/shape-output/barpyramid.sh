#!/bin/sh

count=1
while [ $count -lt 6 ]; do
	innerCount=0;
	string=""
	while [ $innerCount -lt $count ]; do 
		string=$string"|";
		innerCount=$(($innerCount+1))
		if [ $innerCount -lt $count ]; then
			string=$string" "
		else
			string=$string"_"
		fi	
	done
	count=$(($count+1))
	echo $string
done

	
