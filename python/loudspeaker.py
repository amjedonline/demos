from speaker import Speaker

class Loudspeaker(Speaker):
	def __init__(self, message):
		Speaker.__init__(self, message)
		print "In loudspeaker __init__"
		self.message = message
