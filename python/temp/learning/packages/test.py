#!/usr/bin/python2.6

import kitchen

o = Omelet("cheese")
o.set_kind("mushroom")
o_f = Fridge({"cheese":5, "milk":4, "eggs":12, "mushroom":20})
o.get_ingredients(o_f)
o.mix()

o.make()
