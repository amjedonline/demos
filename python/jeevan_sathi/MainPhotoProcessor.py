from sgmllib import SGMLParser
import htmlentitydefs
from urlparse import urlparse
import re


class MainPhotoProcessor(SGMLParser):
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
				parse_result=urlparse(url);
				queryparams = re.split("\?|\&",parse_result.query)
				for param in queryparams:
					keyval = param.split("=")
					if( len(keyval)==2 and keyval[0]=="profileid"):
						final_url = "http://ser7.jeevansathi.com/profile/photo_serve.php?profileid="+keyval[1]
						self.urls.append(final_url);
				break; 

	def output(self):
		"""Return processed HTML as a single string """
		return self.urls
