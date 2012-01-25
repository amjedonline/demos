type "$1" &> /dev/null

if [ $? -eq 0 ] ;then
	echo "Legitimate command";
else
	echo "Command does not exist";
fi
