#!/usr/bin/python2.6


def get_omelet_ingredients(omelet_name):
	"""This contains a dictionary of omelet names"""
	# All of our omelets need egg and milk
	ingredients={"egg":2,"milk":1}
	if omelet_name == "cheese":
		ingredients["cheddar"] = 2
	elif omelet_name == "western":
		ingredients["jack_cheese"] = 2
		ingredients["ham"] = 1
		ingredients["pepper"] = 1
		ingredients["onion"] = 1
	elif omelet_name == "greek":
		ingredients["feta_cheese"] = 2
		ingredients["spinach"] = 2
	else:
		print "That's not on the menu, sorry !"
		return None
	return ingredients

# print get_omelet_ingredients("cheese")

def make_food(ingredients_needed, food_name):
	"""Make food"""
	for ingredient in ingredients_needed.keys():
		print "Adding %d of %s to make a %s" % (ingredients_needed[ingredient], ingredient, food_name)
	print "Made %s" %food_name
	return food_name


def make_omelet(omelet_type):

	"""This will make an omelet. This function contains its own copy of get_omelet_ingredients"""

	def get_omelet_ingredients(omelet_name):
		"""This contains a dictionary of omelet names"""
	# All of our omelets need egg and milk
		ingredients={"egg":2,"milk":1}
		if omelet_name == "cheese":
			ingredients["cheddar"] = 2
		elif omelet_name == "western":
			ingredients["jack_cheese"] = 2
			ingredients["ham"] = 1
			ingredients["pepper"] = 1
			ingredients["onion"] = 1
		elif omelet_name == "greek":
			ingredients["feta_cheese"] = 2
			ingredients["spinach"] = 2
		else:
			print "That's not on the menu, sorry !"
			return None
		return ingredients



	if type(omelet_type) == type({}):
		print "Omelet_type is a dictionary with ingredients"
		return make_food(omelet_type, "omelet")
	elif type(omelet_type) == type(""):
		omelet_ingredients = get_omelet_ingredients(omelet_type)
		return make_food(omelet_ingredients, omelet_type)
	else:
		raise TypeError, "No such omelet type: %s " % omelet_type

make_omelet(["amjed", "shahrukh"])
#make_omelet("greek")
