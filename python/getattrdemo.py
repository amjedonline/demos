def output(data, format="text"):
	""" Outputs the data in the five format."""
	getattr(getattrdemo,format)()

def text(data):
	"""Output in text format"""
	print "Output in text format"

def html(data):
	"""Output data in html format"""
	print "<strong>%s</strong>"%(data,)

output("amjed","html")
