#!/usr/bin/python2.6

input=file("issues.txt")
output=file("output.txt","w")

for line in input:
	if(line.strip()==""):
		continue
	output.write(line.replace("- ",""))
	output.write("\n")

output.close()
input.close()


