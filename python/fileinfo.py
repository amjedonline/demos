from UserDict import UserDict

class FileInfo(dict):
	"store file metadata"
	
	def __init__(self,filename=None):
		UserDict.__init__(self)
		self["name"]=filename
		
	def __getitem__(self, key): return self.data[key]
	
	def __setitem__(self, key, item) : self.data[key]=item

class MP3FileInfo(FileInfo):
	"store file metadata"
	def __setitem__(self, key, item):
		if key== "name" and item:
			self.__parse(item)
		FileInfo.__setitem__(self, key, item)
	
