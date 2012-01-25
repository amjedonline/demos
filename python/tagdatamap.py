file= open("/home/amjed/music/hindi/paheli.mp3","r")
file.seek(-128,2)
tagdata=file.read(128)

def stripnulls(text):
	print text

tagDataMap={
	"title"	:	(3,33, stripnulls),
	"artist":	(33,63, stripnulls),
	"album":	(63,93, stripnulls),
	"year":		(93, 97, stripnulls),
	"comment":	(97,126, stripnulls),
	"genre":	(127,128, stripnulls) }

#if tagdata[:3]=="TAG":
print " ".join(["%s - %s" %(tag,parseFunc(tagdata[start:end]))	for tag, (start, end, parseFunc) in tagDataMap.items()])
#tag= parseFunc(tagdata[start:end])

