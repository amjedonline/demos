#!/usr/bin/env python

import findgtk
import gtk

class Base:
	def __init__(self):
		self.window = gtk.Window(gtk.WINDOW_TOPLEVEL)
		self.window.show()

	def main(self):
		gtk.main()

print __name__
if __name__ =="__main__":
	base = Base()
	base.main()

