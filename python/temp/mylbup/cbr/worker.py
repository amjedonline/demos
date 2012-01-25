#!/usr/bin/python2.6

import cherrypy

class Worker(object):
	def __init__(self,name):
		self.name = name

	def command(self, *args, **kargs):
		return "Reply from %s\n Request parametes : %s" %(self.name, kargs)

class WorkerServer(object):
	
	def __init__(self, port, name):
		self.port = port
		self.worker = Worker(name)

	def start():
		cherrypy.config.update({"server.socket_host":"127.0.0.1","server.socket_port":self.port})
		cherrypy.quickstart(self.worker)

			
