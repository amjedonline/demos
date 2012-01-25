#!/usr/bin/python2.6

import cherrypy
import workers


def print_status(status):
	statusfile=open("status.log","w")
	string=""

	for key in status.keys():
		string=string+key+":"
		for i in range(0, len(status[key])):
				string=string+" "+status[key[i]]
	statusfile.write(string)
	statusfile.close()

class ContentBasedRouter(object):
	def defaultrequest(self):
		return "Serving an object"

	def serve(self, request):
		if request=="w":
			return "Serving a widget"
		elif request == "m":
			return "serving a midget"	
		else:
			return self.defaultrequest()


class Handler(object):

	def __init__(self):
		self.router = ContentBasedRouter()

	def command(self, *args, **kwargs):
		if "request"	not in kwargs.keys():
			return self.router.defaultrequest()
		else :
			return self.router.serve(kwargs["request"])
 
	command.exposed=True


if __name__ =="__main__":
	cherrypy.quickstart(Handler())
