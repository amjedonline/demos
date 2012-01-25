lines=`wc -l tocopy.txt`
#echo $lines
for file in `cat tocopy.txt| line`; do
	echo $file
done
