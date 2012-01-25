class Speaker:
	def __init__(self, message):
		print "Initializing speaker."
		self.message = message

	def speak(self):
		print "Speaking now ...\n%s"%(self.message,)
	
	def speakClass(self):
		print "Speaking from class method...\n%s"%(self.message,)
	
	def speakObject():
		print "Speaking from object method ... \n%s"%(message, )
	
