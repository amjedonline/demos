file = open("sample.html","r")
htmlSource = file.read()
from BaseHTMLProcessor import BaseHTMLProcessor

parser = BaseHTMLProcessor()
parser.feed(htmlSource)
print parser.output()
file.close()
parser.close()
