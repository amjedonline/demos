#!/usr/bin/python2.6

import os
import os.path

def cmp_ext(path0, path1):
	return cmp(os.path.splitext(path0)[1], os.path.splitext(path1)[1])

def showdir(dir):
	for file in sorted(os.listdir(dir), cmp_ext):
		print os.path.join(dir,file)

if __name__ == "__main__":
	showdir("/home/amjed")
