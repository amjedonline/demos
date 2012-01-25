from sgmLlib import SGMLParser
import htmlentitydefs

class BaseHTMLProcessor(SGMLParser):
	def reset(self):
		self.pieces = []
		SGMLParser.reset(self)
	
	def unknown_starttag(self, tag, attrs):
		strattrs = "".join([' %s="%s"' %(key,value) for key, value in attrs] )
		self.pieces.append("<%(tag)s%(strattrs)s>"%locals())

	def unknown_endtag(self, tag):
		self.pieces.append("</%(tag)s>" %locals())

	# This is an interesting function to handle the char refs
	def handle_charref(self, ref):
		self.pieces.append("&#%(ref)s;"%locals())
	
	#Handle entities
	def handle_entityref(self, ref):
		self.pieces.append("&%(ref)s"%locals())
		if(htmlentitydefs.entitydefs.has_key(ref)):
			self.pieces.append(";")
	
	def handle_data(self, text):
		self.pieces.append(text)

	#This is to handle comments
	def handle_comment(self, text):
		self.pieces.append("<!--%(text)s-->"%locals())
	
	def handle_pi(self, text):
		self.pieces.append("<?%(text)s>"%locals())
		
	def handle_decl(self, text):
		self.pieces.append("<!%(text)s>"%locals())

	def output(self):
		"""Return processed HTML as a single string """
		return "".join(self.pieces)
