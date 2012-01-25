#!/usr/bin/python2.6

import cherrypy

class CherryHandler(object):
	def command(self,*args, **kwargs):
		return "Args: %s\n Kwargs: %s"%(args,kwargs)
	command.exposed=True

cherrypy.config.update({"server.socket_host":"127.0.0.1","server.socket_port":9000})
cherrypy.quickstart(CherryHandler()) 
