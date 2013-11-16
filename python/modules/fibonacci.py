def fib(n):    # write Fibonacci series up to n
    print "executing from %s module"%(__name__,)
    a, b = 0, 1
    while b < n:
        print b,
        a, b = b, a+b

if __name__=="__main__":
	fib(10);
