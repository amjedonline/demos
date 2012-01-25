#!/bin/sh

echo "Arguments passed $@ " 
echo "Length is $#"
echo 

seq=`seq 10`

for x in $seq
do
	eval $"$x"
done 

