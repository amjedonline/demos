#!/bin/sh
#emp1.sh: INteractive version - uses read to take two inputs

echo "Enter the pattern to be searched:\c"
read pname
echo "Enter the file to be used:\c"
read flname
echo "Searching for $pname in $flname"
grep "$pname" $flname
echo "Selected records shown above"
