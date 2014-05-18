class OnlyOne:
	class __OnlyOne:
		def __init__(self, arg):

			self.val = arg

	def __str__(self):
			return str(self.instance)+self.val

	instance = None
	
	def __init__(self, arg):
		if not OnlyOne.instance:
			OnlyOne.instance = OnlyOne.__OnlyOne(arg)
		else:
			OnlyOne.instance.val = arg
	
	def __getattr__(self, name):
		return getattr(self.instance, name)


x = OnlyOne('sausage')
print x
z = OnlyOne('egg')
print z
y = OnlyOne('spam')
print y

print x, y, z

	
# Singleton/ClassVariableSingleton.py
# Simpler version

class Simple(object):
	__instance = None

	def __new__(cls, val):
		if Simple.__instance == None:
			Simple.__instance = object.__new__(cls)
		Simple.__instance.val = val
		return Simple.__instance

	def __str__(self):
		return ':'+self.val


a = Simple('Amjed')
print a
b = Simple('Shahrukh')
print b

c = Simple('Shikshak')
print c

