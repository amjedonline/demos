#!/usr/bin/python2.6

import pickle

pickle_file=file("/home/amjed/test.pickle","r")
important_data=pickle.load(pickle_file)
del pickle_file
print important_data
