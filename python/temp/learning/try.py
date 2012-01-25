#!/usr/bin/python2.6

omelet_ingredients = {"egg":10,"peppers":3,"cheese":5,"milk":3,"mushroom":6}
ingredients = omelet_ingredients.keys()
while len(ingredients) > 0:
	current_ingredient = ingredients.pop()
	print "Adding %d %s to the mix" %(omelet_ingredients[current_ingredient], current_ingredient)
