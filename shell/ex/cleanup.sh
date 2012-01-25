#!/bin/bash

# Proper header for a bash shell

# Cleanup, version 2

# RUn as root, of course.
# Insert code here to print error message and exit fi not root.

LOG_DIR=/var/log
ROOT_UID=0		# Only users with $UID 0 have root privileges.
LINES=50		# Default number of lines saved.
E_XCD=86		# Can't change directory?
E_NOTROOT=87		# Non-root exit error.


# Run as root, of course.

if [ "$UID" -ne "$ROOT_UID" ]
then
	echo "Must be root to run this script."
	exit $E_NOT_ROOT 
fi

if [ -n "$1" ]
# Test whether command-line argument is preset (non-empty).
then
	lines=$1
else
	lines=$LINES # Default if not specified on the command line
fi

# An even better way to check the command line argument
E_WRONG_ARGS=85 # Non-numerical argument(bad argument format).

case "$1" in
	""	) lines=50;;
	$[!0-9]*) echo "Usage: `basename $0` file-to-cleanup"; exit $E_WRONGARGS;;
	*	)liens=$1;;
esac


# Variables are better than hard-coded values.
cd $LOG_DIR

if [ `pwd` != "$LOG_DIR" ] #Not in /var/log ?
then 
	echo "Can't change to $LOG_DIR."
	exit $E_XCD
fi # Double check if in right directory before messing with log file.

# Far more efficient is
# cd /var/log || { 
#	echo "Cannot change to necessary directory," > &2
#	exit $E_XCD;
#	}

tail -n $lines messages > mesg.tmp # Save last section of message log file.
mv mesg.temp messages
	
# cat /dev/null > messages
cat /dev/null > wtmp # : > wtmp and > wtmp hve the same effect.
echo "Logs cleaned up."

exit 0 #  Zero indicate success, the right and proper method of "exiting" from a script.

