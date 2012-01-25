#!/bin/bash
#array.sh:Demonstrate the usage of arrays in bash and korn shell
month_arr=(0 31 29 31 30 31 30 31 31 30 31 30 31)
echo ${month_arr[2]}
echo "Length of array \"\${#month_arr[@]}\" is ${#month_arr[@]}";
echo "Contents of the array are ${month_arr[@]}"

