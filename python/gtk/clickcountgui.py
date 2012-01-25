#!/usr/bin/env python

import findgtk
import gtk

class ClickCountGUI:
	
	CLICK_COUNT = "Click count: %d"

	def __init__(self):
		"Set up the window and the button within"
		self.window = gtk.Window()
		self.button = gtk.Button(self.CLICK_COUNT %0)
		self.button.timesClicked = 0
		self.window.add(self.button)

		self.button.connect("clicked", self.buttonClicked)
		self.window.connect("destroy", self.destroy)

		#Show the GUI
		self.button.show()
		self.window.show()

	def buttonClicked(self, button):
		"This button was clicked; increment the message on its lable"
		self.button.timesClicked += 1
		self.button.set_label(self.CLICK_COUNT %self.button.timesClicked)

	def destroy(self, window):
		window.hide()
		gtk.main_quit()

if __name__ == "__main__":
	ClickCountGUI()
	gtk.main()

	
		
