
class Point:
	def __init__(self, x, y):
		self._x, self._y = x, y

	@property
	def x(self):
		return self._x
	
	@x.setter
	def x(self, value):
		self._x = value

	@property
	def y(self):
		return self._y
	
	@y.setter
	def y(self, value):
		self._y = value

p = Point(10,20)
print p.x
print p.y

p.x = 33
print p.x
