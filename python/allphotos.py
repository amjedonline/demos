import urllib
from ImageDownloadParser import ImageDownloadParser

url = "http://www.jeevansathi.com/profile/search.php?searchid=186082991&contact=&SIM_USERNAME=&NAVIGATOR=01cb53e942dd5a8848589fd0af70e1a7&overwrite=1&nextViewSim=1&google_kwd="
def getImagesForPage(page):
	socket = urllib.urlopen(url+"&j="+str(page))
	
	htmlSource = socket.read()
	
	parser = ImageDownloadParser()
	parser.feed(htmlSource)
	urls =  parser.output()
	socket.close()
	parser.close()
	counter=1
	for imageurl in urls:
		print "getting "+imageurl
		imagesocket = urllib.urlopen(imageurl)
		imagedata = imagesocket.read()
		imagefile = open("images/"+str(page)+"-"+str(counter)+".jpeg","w")
		imagefile.write(imagedata)
		imagefile.close()
		imagesocket.close()
		counter=counter+1

pagecount = 3
startpage = 14
for page in range(startpage, startpage+pagecount):
	getImagesForPage(page);
