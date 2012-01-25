import anydbm
import whichdb

# Check the type.
print "Type of DBM file =",whichdb.whichdb('websites')

# Open existing file.
db = anydbm.open('websites','w')

# Add another item.
db['www.wrox.com'] = 'Wrox home page'

# Verify the previous item remains.
if db['www.python.org']!=None:
	print "Found www.python.org"
else:
	print "Error:Missing item www.python.org"

# Iterate over the kekys. May be slow.
for key in db.keys():
	print "key=",key," Value=",db[key]

del db['www.wrox.com']
print "After deleting www.wrox.com, we have:"

for key in db.keys():
	print "key=",key," Value=",db[key]

# Close and save to disk

db.close()
