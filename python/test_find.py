import unittest
import find
import os, os.path

def filename(ret):
	return ret[1]

class FindTest (unitttest.TestCase):
	def setUp(self):
		os.mkdir("_test")
		os.mkdir(os.path.join("_test","subdir"))
		f = open(os.path.join("_test","file1.txt"),w)
		f.write("""first line
		second line

		third lines.
		and fourth line""")
		f.close()

	def tearDown(self):
		os.unlink(os.path.join("_test","file1.txt"))
		os.unlink(os.path.join("_test","subdir"))
		os.rmdir("_test")
	
	def test_01_SearchAll(self):
		""" 1: Test searching for all files."""
		res = find.find(r".*",start = "test")

