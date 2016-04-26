import argparse
parser = argparse.ArgumentParser()
# be default the parameters are treated as string. 
#parser.add_argument("square", help = "display a square of a given number")
# Let us read it as int
parser.add_argument("square", help = "display a square of a given number", type=int)
args = parser.parse_args()
print(args.square**2)
