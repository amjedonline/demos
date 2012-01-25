#!/usr/bin/python2.6

import os
import cgitb

CGI_ENVIRONMENT_KEYS = ['SERVER_SOFTWARE', 'SERVER_NAME', 'SERVER_PROTOCOL', 'SERVER_ADDRESS', 'REMOTE_ADDRESS', 'CONTENT_TYPE', 'CONTENT_LENGTH']
print "Here are the headers of the request you just made:"
for key,value in os.environ.items():
#	if key.find('HTTP_')==0 or key in CGI_ENVIRONMENT_KEYS:
	print key,'=>', value
