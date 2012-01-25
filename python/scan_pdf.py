#!/usr/bin/python2.6

import os, os.path
import re

def print_pdf (arg, dir, files):
	for file in files:
		path = os.path.join(dir,file)
		path = os.path.normcase(path)
		#print path
		if not re.search(r".*\.pdf", path): continue
		if re.search(r"/\.hu",path): continue
		print path
os.path.walk('/home/amjed/ebooks/python',print_pdf,0)


