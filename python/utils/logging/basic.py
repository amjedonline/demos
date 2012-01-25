#!/usr/bin/python2.6

import logging
LOG_FILE_NAME="log-basic.log"
logging.basicConfig(filename=LOG_FILE_NAME, level=logging.DEBUG)

logging.debug("This message should go to the file")
