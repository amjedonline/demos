#!/bin/sh
#checkargument.sh: Check for 3 arguments and exit

if [ $# -ne 3 ]
then
	echo "You have not entered 3 arguments"
	exit 3
fi
