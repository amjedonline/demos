#!/bin/sh

[ $# -ne 3 ] && (echo "Usage: $0 n1 operator n2 "; exit 1; )

case "$2" in
	"+")	echo $(($1 + $3));;
	"-")	echo $(($1 - $3));;
	"/")	echo $(($1 / $3));;
	"*")	echo $(($1 * $3));;
	*)	echo "Invalid operation"
esac
