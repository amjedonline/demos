#!/usr/bin/python2.6

import urllib2
import urllib

params = urllib.urlencode((("j_username","infospace"),("j_password","info1@#$"),("submit", "Go!")))
req=urllib2.Request(url="https://192.168.1.11:8443/semgel/j_security_check",data=params)
f = urllib2.urlopen(req, timeout=15.0)
file = open("/home/amjed/Desktop/cont.txt","w")
file.write(f.read())
file.close()
f.close()
