#!/usr/bin/python2.6

import logging
import sys

LEVELS = {"debug":logging.DEBUG,
		"warn":logging.WARN,
		"info":logging.INFO,
		"error":logging.ERROR,
		"critical":logging.CRITICAL}

if(len(sys.argv)>1):
	level=LEVELS.get(sys.argv[1], logging.NOTSET)
	logging.basicConfig(level=level)

logging.info("this is an info message")
logging.debug("this is a debug message")
logging.warn("this is a warn message")
logging.error("this is an error message")
logging.critical("this is a critical message")

