#!/usr/bin/python2.6

from xml.dom.minidom import parse
import xml.dom.minidom

def printLibrary(library):
	books = library.getElementsByTagName("book")
	for book in books:
		print "***** Book *****"
		print "Title: %s" %book.getElementsByTagName("title")[0].childNodes[0].data
		for author in book.getElementsByTagName("author"):
			print "Author: %s" %author.childNodes[0].data
		print 

# Open an XML file and parse it into DOM
myDoc = parse("library.xml")
myLibrary = myDoc.getElementsByTagName("library")[0]

printLibrary(myLibrary)

# Insert a new book in the library
newBook = myDoc.createElement("book")
newTitle = myDoc.createElement("title")
titleText = myDoc.createTextNode("Beginning Title")
newTitle.appendChild(titleText)
newBook.appendChild(newTitle)

newAuthor = myDoc.createElement("author")
authorText = myDoc.createTextNode("Peter Norton, et al")
newAuthor.appendChild(authorText)
newBook.appendChild(newAuthor)
myLibrary.appendChild(newBook)

print "\nAdded a new Book"
printLibrary(myLibrary)


# Remove all the Books authored by author having name containing Ellison
for book in myLibrary.getElementsByTagName("book"):
	for author in book.getElementsByTagName("author"):
		if author.childNodes[0].data.find("Ellison")!=-1:
			removedBook = myLibrary.removeChild(book)
			removedBook.unlink()
			
print "Removed a book."
printLibrary(myLibrary)
