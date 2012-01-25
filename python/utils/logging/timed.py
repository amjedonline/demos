#!/usr/bin/python2.6

import logging
import logging.handlers
import time

LOG_FILENAME = "rotate-time.log"
mylogger = logging.getLogger("MyLogger")
mylogger.setLevel(logging.DEBUG)

handler = logging.handlers.TimedRotatingFileHandler( LOG_FILENAME, when="M")

mylogger.addHandler(handler)

for i in range(20):
	time.sleep(60)
	mylogger.debug("Debugging -%s " %i)
