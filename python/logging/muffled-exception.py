#!/usr/bin/python2.6

class MuffledCalculator:
	muffled = 0
	
	def calc(self, expr):
		try:
			return eval(expr)
		except ZeroDivisionError:
			if self.muffled:
				print "Division by zero is illegal"
			else:
				raise

if __name__ == "__main__":
	calc = MuffledCalculator()
	calc.muffled=1
	calc.calc("1/0")


