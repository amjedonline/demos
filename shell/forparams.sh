#!/bin/sh
#forparams: Show how to iterate throw all the passed in command line parameters

for param in $*
do
	echo $param
done
