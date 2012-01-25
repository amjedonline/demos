import os
import sys
import shutil

for root, subFolders, files in os.walk("/home/amjed"):
	for file in files:
		print "root:"+root+" subFolders:"+subFolders+" file:"+file
	
