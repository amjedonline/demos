#!/bin/sh

#hostname.sh: Find out the hostname, also illustrate how to check for a file before it is executed
if test -f /sbin/sysctl 
then
	/sbin/sysctl -n kernel.hostname
fi
