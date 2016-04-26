import csv
statement = '$SUBREASON$("$CATEGORY$", "$TYPE$", "$SUB_TYPE$", "$SUB_TYPE2$", FieldConstraint.$ORDERNO_FIELD$, FieldConstraint.$ARTICLENO_FIELD$, FieldConstraint.$PAYMENTMETHOD_FIELD$, FieldConstraint.$VOUCHERNO_FIELD$),'

def substitute(string, valuedict):
	for key in valuedict:
		string = string.replace(key, valuedict[key])
	return string

with open('contact-form-definition.csv', 'rbU') as f:
	reader = csv.reader(f)
	for row in reader:
		valuedict={'$SUBREASON$':'','$CATEGORY$': '', '$TYPE$':'','$SUB_TYPE$':'', '$SUB_TYPE2$':'', '$ORDERNO_FIELD$':'OPTIONAL', '$ARTICLENO_FIELD$':'OPTIONAL', '$PAYMENTMETHOD_FIELD$':'OPTIONAL', '$VOUCHERNO_FIELD$':'OPTIONAL'}
		colnum = 0
		for col in row:
			if colnum == 0:
				valuedict['$CATEGORY$'] = col
			if colnum == 1:
				valuedict['$SUBREASON$'] = col
			elif colnum == 2:
				valuedict['$TYPE$'] = row[colnum]
			elif colnum == 3:
				valuedict['$SUB_TYPE$'] = row[colnum]
			elif colnum == 4:
				valuedict['$SUB_TYPE2$'] = row[colnum]
			elif colnum == 11:
				valuedict['$ORDERNO_FIELD$'] = row[colnum].upper()
			elif colnum == 12:
				valuedict['$ARTICLENO_FIELD$'] = row[colnum].upper()
			elif colnum == 13:
				valuedict['$PAYMENTMETHOD_FIELD$'] = row[colnum].upper()
			elif colnum == 14:
				valuedict['$VOUCHERNO_FIELD$'] = row[colnum].upper()
			colnum += 1
		print substitute(statement, valuedict)

		#print statement.replace("$ORDER$", str(rownum)).replace("$ST$", st).replace("$TYPE$", typ).replace("$ST_DESC$", st_desc) 
