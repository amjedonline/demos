#!/bin/sh
#while.sh:Shows the use of the while loop

answer=y
while [ "$answer" = "y" ]
do
	echo "Enter the code and the description:\c" >/dev/tty
	read code description
	echo "$code|$description" 
	echo "Enter any anymore(y/n) ?\c" > /dev/tty
	read anymore
	case $anymore in
		n*|N*) answer=n;;
		y*|Y*) answer=y;;
		    *) answer=y;;
	esac
done >> newlist
