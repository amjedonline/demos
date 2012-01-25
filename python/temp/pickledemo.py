#!/usr/bin/python2.6

import pickle
important_data=("hello world", 10, 16.5)
pickle_file=file("/home/amjed/test.pickle", "w")
pickle.dump(important_data, pickle_file)
del pickle_file
