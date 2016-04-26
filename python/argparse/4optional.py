import argparse

parser = argparse.ArgumentParser()
# parser.add_argument("--verbosity", help = "increase output verbosity")
# Only two values True and False are useful
# parser.add_argument("--verbosity", help = "increase output verbosity", action="store_true")

# Add short options
parser.add_argument("-v", "--verbosity", help = "increase output verbosity", action="store_true")
args = parser.parse_args()
if args.verbosity:
    print("verbosity turned on")

