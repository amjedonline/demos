#!/bin/sh
#forls.sh: Shows how the source for "for" loop could be a shell command

for file in `ls`; do
	echo $file
done
