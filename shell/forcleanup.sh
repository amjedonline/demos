#!/bin/sh
#forls.sh: Shows how the source for "for" loop could be a shell command

for file in `ls`; do
	echo "cleaning "$file"\n"
	svn cleanup $file
done
