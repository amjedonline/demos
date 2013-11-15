
from HTMLParser import HTMLParser

class TagHandler:
    pass

class NoteHandler(TagHandler):

    def start(self, out, tag, attrs):
		out.write("<html>")

    def data(self, out, data):
        pass

    def end(self, out):
        out.write("</html>")

class TitleHandler(TagHandler):

    def start(self, out, tag, attrs):
        out.write("<head><title>")

    def data(self, out, data):
        if not data.strip():
            return
        out.write(data)

    def end(self, out):
        out.write("</title></head>")

class NoteContentHandler(TagHandler):

    def start(self, out, tag, attrs):
        out.write("<body>")

    def data(self, out, data):
		if not data.strip():
			return
		data = data.replace("\n", "<br/>")
		out.write("<p>"+data+"</p>")

    def end(self, out):
        out.write("</body>")

class BoldHandler(TagHandler):
    def start(self, out, tag, attrs):
        out.write("<b>")

    def data(self, out, data):
		if not data.strip():
			return
		data = data.replace("\n", "<br/>")
		out.write(data)

    def end(self, out):
        out.write("</b>")


class TomboyParser(HTMLParser):

    def __init__(self, out):
        HTMLParser.__init__(self)
        self.out = out
        self.tagmap={}
        self.tagmap["note"] = NoteHandler()
        self.tagmap["note-content"] = NoteContentHandler()
        self.tagmap["bold"] = BoldHandler()
        self.tagmap["title"] = TitleHandler()
        self.currentTag = None

    def handle_starttag(self, tag, attrs):
        self.currentTag = tag
        if tag in self.tagmap:
            self.tagmap[tag].start(self.out,tag, attrs)

    def handle_endtag(self, tag): 
        if tag in self.tagmap:
            self.tagmap[tag].end(self.out)

    def handle_data(self, data):
        if self.currentTag in self.tagmap:
            self.tagmap[self.currentTag].data(self.out, data)
         

file = open("sample.html", "w")
parser = TomboyParser(file)

note = open("sample.note", "r")

parser.feed(note.read())
note.close()
file.close()
