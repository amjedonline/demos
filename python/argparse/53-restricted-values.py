import argparse

# Combining Positional and Optional Arguments
parser = argparse.ArgumentParser()
parser.add_argument("square", type=int, help="display a square of a given number")
parser.add_argument("-v", "--verbose", type=int, choices=[0, 1, 2], help="increae output verbosity")
args = parser.parse_args()

answer = args.square**2

if args.verbose == 2:
    print("the square of {} equals {}".format(args.square, answer))
elif args.verbose == 1:
    print("{}pow2 = {}".format(args.square, answer))
else :
    print(answer)

