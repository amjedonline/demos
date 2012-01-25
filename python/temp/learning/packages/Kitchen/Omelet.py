#!/usr/bin/python2.6

class Omelet:
	def __init__(self, kind = "cheese"):
		""" Initialize the omelet class to default to a cheese omelet"""
		self.kind = kind
		return 

	def __ingredients__(self):
		return self.needed_ingredients

	def get_kind(self):
		return self.kind

	def set_kind(self, kind):
		possible_ingredients = self.__known_kinds(kind)
		if possible_ingredients == False:
			return False
		else:
			self.kind = kind
			self.needed_ingredients = possible_ingredients
	
	def set_new_kind(self, name, ingredients):
		self.kind = name
		self.needed_ingredients = ingredients
		return
	
	def __known_kinds(self, kind):
		if kind == "cheese":
			return {"eggs":2, "milk":1, "cheese":1}
		if kind == "mushroom":
			return {"eggs":2, "milk":1, "cheese":1, "mushroom":2}
		if kind == "onion":
			return {"eggs":2, "milk":1, "cheese":1, "onion":1}
		else:
			return False
	
	def get_ingredients(self, fridge):
		self.from_fridge = fridge.get_ingredients(self)

	def mix(self):
		for ingredient in self.from_fridge.keys():
			print "Mixing %d %s for the %s omelet" %( self.from_fridge[ingredient], ingredient, self.kind)
			self.mixed = True

	def make(self):
		if self.mixed == True:
			print "Cooking the %s omelet!" %self.kind
			self.cooked = True
