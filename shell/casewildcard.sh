#!/bin/sh
#casewildcard.sh : Demonstrate the wild card usage in the case matching 
echo "Do you want to continue : (yes/no)\c"
read anymore
case $anymore in
	y*|Y*) echo "i will continue";;
	n*|N*) echo "Sorry i may not continue";;
esac

