#!/bin/sh
#forcut.sh:Shows for cut can be used to extract the usernames from the passwd file and show em in for loop

for user in `cat /etc/passwd | cut -f1 -d ":"`; do
	echo $user
done
