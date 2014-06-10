def print_params(**kwargs):
	for key, value in kwargs.iteritems():
		print "%s = %s" %(key, value)

print_params(name="Amjed", age = "27")

_dict = {'location':'Berlin', 'interests':['Swimming', 'Hacking','Paragliding']}

print_params(**_dict)
