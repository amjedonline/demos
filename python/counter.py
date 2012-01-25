class counter:
	count = 0
	def __init__(self):
		self.__class__.count= self.__class__.count+1
