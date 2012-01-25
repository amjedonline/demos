from sgmllib import SGMLParser
import htmlentitydefs

class ImageDownloadParser(SGMLParser):
	def reset(self):
		self.urls = []
		SGMLParser.reset(self)
	
	def unknown_starttag(self, tag, attrs):
		if(tag=="div"):
			for key, value in attrs:
				if(key=="style"):
					self.handlestyle(value)

	def handlestyle(self, value):
		styleattrs = value.split(";")
		for pair in styleattrs:
			keyvalue = pair.split(":");
			if( len(keyvalue)>1 and keyvalue[0].find("background-image")>-1 ):
	
				url = "http:"+keyvalue[2].rstrip(")")
				self.urls.append(url);
				break; 

	def output(self):
		"""Return processed HTML as a single string """
		return self.urls
