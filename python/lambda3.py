def getCollapseDecision(collapse):
	return collapse and (lambda s: " ".join(s.split())) or (lambda s:s)
text="""This is \t my life\n\n, and am taking \t\t\tcontrol of it\n"""
print "Before applying the process function:\n%s"%text
process=getCollapseDecision(True)
print "\nAfter applying the function:\n%s"%process(text)
