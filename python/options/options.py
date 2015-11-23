#!/usr/bin/env python3

import sys, getopt

def main1(argv):
    try:
        opts,args = getopt.getopt(argv, "", [])
        print(args)
    except getopt.GetOptError:
        print('Error parsing options')
def main(argv):
    if len(argv) != 2:
        print("please give exact 1 argument")
        return 
    print(argv[1])

if __name__ == '__main__':
    main(sys.argv)
