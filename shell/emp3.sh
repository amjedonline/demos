#!/bin/sh
#emp3.sh: Using if and else

if grep "^$1" /etc/passwd 2>/dev/null
then
	echo "Pattern found - Job over"
else
	echo "Pattern not found"
fi
