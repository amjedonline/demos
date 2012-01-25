#!/bin/sh

[ $# -ne 2 ]  && ( echo "You have not entered 3 arguments.\n Usage:$0 num1 num2 "; exit 2)

echo  $(( $1 + $2 ))
