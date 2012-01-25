#!/usr/bin/python2.6

import cherrypy
import logging
import logging.handlers

class CherryHandler(object):
	def command(self,*args, **kwargs):
		return "Args: %s\n Kwargs: %s"%(args,kwargs)
	command.exposed=True

cherrypy.config.update({"server.socket_host":"127.0.0.1","server.socket_port":9000})
handler = logging.handlers.RotatingFileHandler("rotate",maxBytes=20, backupCount=5)
handler.setLevel(logging.INFO)
#cherrypy.log.access_log.addHandler(handler)
log = cherrypy.log

# Remove the default FileHandlers if present.
log.error_file = ""
log.access_file = ""

maxBytes = getattr(log, "rot_maxBytes", 10000000)
backupCount = getattr(log, "rot_backupCount", 1000)

# Make a new RotatingFileHandler for the error log.
fname = getattr(log, "rot_error_file", "error.log")
h = logging.handlers.RotatingFileHandler(fname, 'a', maxBytes, backupCount)
h.setLevel(logging.INFO)
log.error_log.addHandler(h)

# Make a new RotatingFileHandler for the access log.
fname = getattr(log, "rot_access_file", "access.log")
h = logging.handlers.RotatingFileHandler(fname, 'a', maxBytes, backupCount)
h.setLevel(logging.INFO)
log.access_log.addHandler(h)


cherrypy.quickstart(CherryHandler()) 

