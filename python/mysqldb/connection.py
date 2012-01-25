#!/usr/bin/python
import MySQLdb

conn = MySQLdb.connect(host="localhost", user="root", passwd="root", db="se")
cursor = conn.cursor()
cursor.execute("SELECT VERSION()")
row = cursor.fetchone()
print "Sever version: ",row[0]
cursor.close()
conn.close()

