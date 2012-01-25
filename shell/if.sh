#!/bin/sh
echo "You passed in $# parameters"
if [ $# -eq 0 ]
then
	echo "You did not pass any parameters"
fi
