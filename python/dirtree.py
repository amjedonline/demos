import os
from xml.sax.saxutils import quoteattr as xml_quoteattr

def DirAsLessXML(path):
    result = '<dir name=%s>\n' % xml_quoteattr(os.path.basename(path))
    for item in os.listdir(path):
        itempath = os.path.join(path, item)
        if os.path.isdir(itempath):
            result += '\n'.join('  ' + line for line in 
                DirAsLessXML(os.path.join(path, item)).split('\n'))
        elif os.path.isfile(itempath):
            result += '  <file name=%s />\n' % xml_quoteattr(item)
    result += '</dir>'
    return result

if __name__ == '__main__':
    print '<structure>\n' + DirAsLessXML(os.getcwd()) + '\n</structure>'
