#!/usr/bin/python2.6

import glob
import re

list = lambda ls : [x for x in glob.glob(ls) if re.search(".*\.jpg",x) ]
print list("/home/amjed/*")
