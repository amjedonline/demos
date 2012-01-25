#!/bin/sh

counter=1
while true 
	do
		echo "m alive, and the counter is $counter "
		counter=$(($counter+1));
		sleep 1;
	done

