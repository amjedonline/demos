#!/usr/bin/python2.6

import urllib2

auth_handler = urllib2.HTTPBasicAuthHandler()
auth_handler.add_password(realm="Semgel Product Authentication", uri="https://192.168.1.11", user="infospace", passwd="info1@#$")
opener = urllib2.build_opener(auth_handler)
# Can use opener directly , if u dont want to use the urllibr.urlopen() globally with the handler

urllib2.install_opener(opener)
testserver = "https://192.168.1.11:8443"
contents = urllib2.urlopen(testserver)
file = open("/home/amjed/Desktop/test","w")
file.write(mails.read())
file.close()
mails.close()

