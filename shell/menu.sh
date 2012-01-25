#!/bin/sh

#menu.sh Uses case to offer 5 options menu
echo "	Menu\n
1. List files\n2. Processes of user\n3. Today's date
4. Users of system\n5. Quit to linux termincal\nEnter your choice:\c"
read choice

case $choice in
	1) ls -l;;
	2) ps -f;;
	3) date;;
	4) who;;
	5) exit;;
	*) echo "invalid option";;
esac
