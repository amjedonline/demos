#!/usr/bin/python2.6

import os
import shutil

def make_version_path(path, version):
	if version==0:
		# No suffix for o, the current version.
		return path
	else:
		# Append a suffix to indicate the older verion.
		return path + "." + str(version)

def rotate(path, version=0):
	# Construct the name of the version we're rotating.
	old_path=make_version_path(path, version)
	if not os.path.exists(old_path):
		# If doesnt exists, complain
		raise IOError, "'%s' doesn't exists" % path
	# Construct the new version name for this file.
	new_path=make_version_path(path,version+1)
	
	# Is there already a version with this name ?
	if os.path.exists(new_path):
		# Yes. Rotate it out of the way first !
		rotate(path, version+1)

	# Now we can rename the version safely
	shutil.move(old_path, new_path)


def rotate_log_file(path):
	if not os.path.exists(path):
	# This file is missing, so create it
		new_file=file(path,"w");
		del new_file
	# Now rotate it
	rotate(path)

rotate_log_file("/home/amjed/sample.txt")
