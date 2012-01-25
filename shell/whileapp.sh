#!/bin/sh
#whileapp.sh: Shows the application of while loop to wait for an operation

while [ ! -r invoice.lst ] 
do	
	sleep 60
done

cp invoice.lst invoice_bak.lst
