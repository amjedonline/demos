try:
	fsock=open("/notthere")
except IOError:
	print "Error occurred, file not found"
print "this will get printed anyway"
