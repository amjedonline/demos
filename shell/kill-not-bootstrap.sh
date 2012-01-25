for pid in `sudo jps | awk '{print $1}' `;
do if [ $pid != "26288" ]; 
	then
	 echo "killing "$pid; sudo kill -9 $pid; 
	fi
done


