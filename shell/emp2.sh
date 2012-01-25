#!/bin/sh
#emp2.sh Non-interactive version - uses command line arguments

echo "Program $0"
echo "Number of arguments specified:$#"
echo "The arguments are: $*"
grep "$1" $2
echo "\nJob Over"

