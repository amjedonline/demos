def buildConnectionString(params):
	return ";".join(["%s=%s" % (k,v) for k, v in params.items()])
	

if __name__ == "__main__":
	myParams = {"server": "localhost", "port":"8080"}
	print buildConnectionString(myParams)
