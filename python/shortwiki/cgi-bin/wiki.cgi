#!/usr/bin/python
import re, os, os.path, cgi, popen2; env, ex = os.getenv, os.path.exists
def load(n): return (ex('w/'+n) and open('w/'+n).read()) or ''
def fs(s): return reduce(lambda s, r: re.sub('(?m)'+r[0], r[1], s), (('\r',''),
   ('(^|[^A-Za-z0-9?])(([A-Z][a-z]+){2,})', lambda m: (m.group(1) + '%s<a hr' \
    'ef=wypy?%s'+m.group(2)+'%s>%s</a>') % ((m.group(2),'p=','&amp;q=e','?'), 
   ('','','',m.group(2)))[ex('w/'+m.group(2))]),  ('^\{\{$','\n<ul>'), 
   ('^\* ','<li>'),  ('^}}$','</ul>'),  ('^---$','<hr>'),  ('\n\n','<p>'), 
   ('(ht|f)tp:[^<>"\s]+','<a href="\g<0>">\g<0></a>')), cgi.escape(s))
def do(m, n): return {'get':'<h1>WyPy:<a href=wypy?p=%s&amp;q=f>%s</a></h1>(' \
   '<a href=wypy?p=%s&amp;q=e>edit me</a>)<p>%s' % (n, n, n, fs(load(n)) or n),
   'edit': '<form action=wypy?%s method=POST><h1>%s<input type=hidden name=p' \
   ' value=%s> <input type=submit></h1><textarea name=t rows=15 cols=80>%s</' \
   'textarea></form>' % (n, fs(n), n, load(n) or "Describe %s" % n), 'find': 
   ('<h1>Links: %s</h1>' % fs(n))+fs('{{\n* %s\n}}' % '\n* '.join(filter(
    lambda s: open('w/'+s).read().find(n) > -1, os.listdir('w'))))}.get(m)
def main(f): 
   n = f.get('p') or env("QUERY_STRING") or ''; n = ('HomePage',n)[n.isalpha()]
   print "Content-type: text/html; charset=utf-8\r\n\r\n<title>%s</title>" % n
   if env("REQUEST_METHOD") == "POST": open('w/'+n, 'w').write(f['t'])
   print do({'e':'edit', 'f':'find'}.get(f.get('q')) or 'get', n)
if __name__=="__main__": 
   main(dict([(i.name, i.value) for i in cgi.FieldStorage().list]))
