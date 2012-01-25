import urllib

socket = urllib.urlopen("http://stackoverflow.com/questions/1872965/get-vs-post-in-ajax")
html = socket.read()
print html
