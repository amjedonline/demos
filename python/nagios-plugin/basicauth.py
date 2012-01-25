#!/usr/bin/python2.6

import urllib2

auth_handler = urllib2.HTTPBasicAuthHandler()
auth_handler.add_password(realm="New mail feed", uri="https://mail.google.com", user="amjedonline@gmail.com", passwd="rbdc9prvmg")
opener = urllib2.build_opener(auth_handler)
# Can use opener directly , if u dont want to use the urllibr.urlopen() globally with the handler

urllib2.install_opener(opener)
gmailrss = "https://mail.google.com/mail/feed/atom"
mails = urllib2.urlopen(gmailrss)
file = open("/home/amjed/Desktop/mails.xml","w")

file.write(mails.read())
file.close()
mails.close()

