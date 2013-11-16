from pets import Pet

class Dog(Pet):

	def __init__(self, name, chases_cats):
		Pet.__init__(self, name, "Dog")
		self.chases_cats = chases_cats
	
	def chasesCats(self):
		return self.chases_cats

	def __str__(self):
		return "This s a dog"

