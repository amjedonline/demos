import argparse

# Combining Positional and Optional Arguments
parser = argparse.ArgumentParser()
parser.add_argument("square", type=int, help="display a square of a given number")

# can use something like -vv or --verbosity --verbosity
parser.add_argument("-v", "--verbosity", action="count", help="increae output verbosity")
args = parser.parse_args()

answer = args.square**2

if args.verbosity >= 2:
    print("the square of {} equals {}".format(args.square, answer))
elif args.verbosity >= 1:
    print("{}pow2 = {}".format(args.square, answer))
else :
    print(answer)

