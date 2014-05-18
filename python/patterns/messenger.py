# MessengerIdiom, Transfer Object

class Messenger:
	def __init__(self, **kwargs):
		self.__dict__ = kwargs

m = Messenger(name = "Amjed", info = ["28","Berlin", ["Swimming", "Scuba diving"]])

m.more = "Yeh Dil Maange More!!"

print m.name, m.info, m.more
