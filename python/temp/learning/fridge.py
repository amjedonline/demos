#!/usr/bin/python2.6

class Fridge:
	"""This class implements a fridge where ingredients can be added and removed individually, or in groups.
	The fridge will retain a count of every ingredient added or removed, and will raise an error if a suffifient quantity of an ingredient isn't preset.
	Methods:
	has(food_name [,quantity]) - Checks if the string food_name is in the fridge.
	Quantity will be set to 1 if you don't specify a number.
	has_various(foods) - Checks if enough of every food in the dictionary is in the fridge
	add_one(food_name) - Adds a single food_name to the fridge
	add_many(food_dict) - Adds a whole dictionary filled with food
	get_one(food_name) - takes out a single food_name from the fridge
	get_ingredients(food) - If passed an object that has the __ingredients__ method, get_many will invoke this to get the list of ingredients."""

	def __init__(self, items={}):
		""" Optionally pass in an initial dictionary of items"""
		if type(items) != type({}):
			raise TypeError, "Fridge requires a dictionary but was given %s" %type(items)
		self.items = items
		return
	

	def __add_multi(self, food_name, quantity):
		if not self.items.has_key(food_name):
			self.items[food_name] = 0
		self.items[food_name] = self.items[food_name] + quantity

	
	def add_one(self, food_name):
		if type(food_name) != type(""):
			raise TypeError, "add_one requires a string, given a %s" % type(food_name)
		else:
			self.__add_multi(food_name, 1)
		return True


	def add_many(self, food_dict):
		if type(food_dict) != type({}):
			raise TypeError, "add_many requires a dictionary, given a %s" %type(food_dict)
		for food_name in food_dict.keys():
			self.__add_multi(food_name, food_dict[food_name])
		return


	def has(self, food_name, quantity=1):
		return self.has_various({food_name:quantity})


	def has_various(self, food_dict):
		try:
			for food in food_dict.keys():
				if self.items[food] < food_dict[food]:
					return False
			return True
		except KeyError:
			return False
		

	def __get_multi(self, food_name, quantity):
		try:
			if not self.has(food_name, quantity):
				return False
			self.items[food_name] = self.items[food_name] - quantity
		except KeyError:
			return False
		return quantity


	def get_one(self, food_name):
		if type(food_name) != type(""):
			raise TypeError, "get_one requires a string, given a %s" %type(food_name)
		else:
			result = self.__get_multi(food_name, 1)
		return result
	

	def get_many(self, food_dict):
		if type(food_dict) != type({}) :
			raise TypeError, "get_many requires a dictionary, given a %s" %type(food_dict)

		if self.has_various(food_dict):
			foods_removed = {}
			for item in food_dict.keys():
				foods_removed[item] = self.__get_multi(item, food_dict[item])
			return foods_removed

	
	def get_ingredients(self, food):
		try:
			ingredients = self.get_many(food.__ingredients__())
		except AttributeError:
			return False

		if ingredients != False:
			return ingredients




class Food:

	def __init__(self, ingredients = {}):
		self.ingredients = ingredients

	def __ingredients__(self):
		return self.ingredients

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

f = Fridge({"eggs":12, "cheese":3, "grape":1, "milk":4})
print f.items
print f.add_one("orange")
print f.items
f.add_many({"mushroom":5, "tomato":3})
print f.items


# has and has_various test

if f.has("cheese", 2):
	print "There are atleast 2 cheese in the fridge"
else:
	print "There are'nt 2 cheese in the fridge"

if f.has_various({"eggs":3,"tomato":1}):
	print "Its time to make an omelet"
else:
	print "Lets go for shopping for egg and tomato"

if f.has("orange",3):
	print "Go squeeze the orange"
else:
	print "No orange juice today"


food = Food({"eggs":10, "milk":1})

print f.get_ingredients(food)


# Test the bew Omelet class working with Fridge class

o = Omelet("cheese")
o.set_kind("mushroom")
o_f = Fridge({"cheese":5, "milk":4, "eggs":12, "mushroom":20})
o.get_ingredients(o_f)
o.mix()

o.make()
