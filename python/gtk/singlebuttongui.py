#!/usr/bin/env python

import findgtk
import gtk

class SingleButtonGUI:
	def __init__(self, msg = "Hello world"):
		"Set up the window and button within"
		self.window = gtk.Window()
		self.button = gtk.Button(msg)
		self.window.add(self.button)

		#Show the GUI
		self.button.show()
		self.window.show()


if __name__ == "__main__":
	SingleButtonGUI()
	gtk.main()
	
