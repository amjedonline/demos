#$!/bin/sh
echo "Take 2 numbers as argument, add them. If 2 numbers are not given, show an error message";
if test $# -lt 2;
then 
	echo "Usage is $0 num1 num2 "
	exit 1
else
	sum=`expr $1 + $2`
	echo $sum
fi
