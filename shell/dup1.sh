#$!/bin/sh
echo "Takes 2 numbers as argument, add them. If 2 numbers are not given, show an error message";
if [ $# -eq 0 ];then 
	echo "Usage is $0 num1 num2 "
	exit 1
elif [ $# -lt 2 ];then 
	echo "Please enter exactly two numbers"
	exit 1
else
	sum=`expr $1 + $2`
	echo $sum
fi
