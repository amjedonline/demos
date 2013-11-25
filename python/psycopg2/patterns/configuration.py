
class config(dict):
	
	def __getattr__(self, name):
		return self[name]

	def __setattr__(self, name, value):
		self[name] = value


if __name__ == '__main__':
	zonfig = config()
	zonfig.name = 'Amjed'
	zonfig.email = 'anonymous@nsa.gov'
	
	print zonfig.name
