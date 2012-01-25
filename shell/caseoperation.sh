#!/bin/sh
#caseoperation.sh: Use case statement to offer various mathematical operations on given operands

echo "Enter the value of x:\c"
read x
echo "Enter the value of y:\c"
read y
echo "Operator menu"
echo "1. Addition\n2. Substraction\n3. Multiplication\n4. Division\n"
echo "Enter your choice:\c"
read operator
case "$operator" in
	1)	echo "Performing Addition ..."
		echo $((x+y));;
	2)	echo "Performing Substraction..."
		echo $((x-y));;
	3)	echo "Performing Multiplication..."
		echo $((x*y));;
	4)	echo "Performing Division..."
		echo $((x/y));;
	*)	echo "Invalid operation"
esac	
