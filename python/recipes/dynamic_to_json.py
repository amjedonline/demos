import json

class UInfo():
	    def __init__(self):
			self.name="amjed"
			self.age=28
			self.browser={"name":"Mozilla", "version":10.3}
a=UInfo()
print json.dumps(a, default=lambda o:o.__dict__)

	# important: Also check out jsonpickle to serialize and deserialize any python object

