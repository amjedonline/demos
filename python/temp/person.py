#!/usr/bin/python2.6

class Person:
	def speak(self):
		print "Am a person"
	
	def grin(self):
		print "LMAO"

	def eat(self, meal):
		print "eating "+meal


person = Person()
person.speak()
person.grin()
person.eat("lunch")
