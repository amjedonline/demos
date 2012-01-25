#!/bin/sh
#Script.sh Simple shell script example

echo "Today's date:`date`"
echo "This month's calendar:"
cal `date "+%m 20%y"`
echo "My shell:$SHELL"

