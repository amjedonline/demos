#!/usr/bin/python

import sys
import MySQLdb
try:
	conn = MySQLdb.connect(host="localhost",user="root",passwd="root",db="animal")
except MySQLdb.Error, e:
	print "Error %d: %s"%(e.args[0], e.args[1])
	sys.exit(1)

cursor = conn.cursor()
cursor.execute("DROP TABLE IF EXISTS animal")
cursor.execute(""" CREATE TABLE animal
		(
			name CHAR(40),
			category CHAR(40)
		)
	""")
cursor.execute("""
		INSERT INTO animal(name, category)
		VALUES
		('snake','reptile'),
		('frog','amphibian'),
		('tuna','fish'),
		('racoon','mammal')
		""")
print "Number of rows inserted: %d"%cursor.rowcount

cursor.execute("SELECT name, category from animal")
while(1):
	row = cursor.fetchone()
	if row == None:
		break
	print "%s, %s"%(row[0],row[1])
print "Number of rows returned: %d"%cursor.rowcount
