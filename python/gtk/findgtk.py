#!/usr/bin/env python
"""
findgtk.py - FInd the pyGTK libraries, wherever they are.
"""

import os
import sys
sys.path.append("/usr/local/lib/python2.3/site-packages/")

def try_import():
	import sys
	"""tries to import gtk and if successful, return s1"""
	#print "Attempting to load gtk... Path=%s"%sys.path
	#To require 2.0
	try:
		import pygtk
		# prevent from using earlier versions of pygtk
		pygtk.require("2.0")
	except:
		print "pyGTK not found. Ypu need GTK 2 to run this."
	try:
		import gtk, gtk.glade
		import atk, pango #for py2exe
		import gobject
	except:
		import trackback, sys
		trackback.print_exc(file=sys.stdout)
		print "You do not have GTK2 installed"
		return 0
	return 1

try_import()
