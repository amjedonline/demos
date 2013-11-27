class InvalidNameException(Exception):
	pass

def sendName(name):
	if name == None:
		raise InvalidNameException("%s is not a valid name"%(name))
	print "Send name %s ... " %(name)

def execute(text):
	try:
		sendName(text)
		print "Executed"
	except InvalidNameException, ine:
		print ine
	
if __name__ == "__main__":
	execute(None)
	execute('Amjed')
