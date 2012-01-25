#!/usr/bin/python2.6

import logging
import logging.handlers

LOG_FILENAME = "log-rotate.log"
mylogger = logging.getLogger("MyLogger")
mylogger.setLevel(logging.DEBUG)

handler = logging.handlers.RotatingFileHandler( LOG_FILENAME, maxBytes=20, backupCount=5)

mylogger.addHandler(handler)

for i in range(20):
	mylogger.debug("i = %s" %i)
