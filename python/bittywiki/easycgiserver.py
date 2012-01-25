from BaseHTTPServer import HTTPServer
from CGIHTTPServer import CGIHTTPRequestHandler

httpd = HTTPServer(("localhost", 8008), CGIHTTPRequestHandler)
httpd.serve_forever()
