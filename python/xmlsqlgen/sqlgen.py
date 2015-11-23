from xml.dom.minidom import parse
import xml.dom
import os
import re

import datetime


class Event(dict):

	usableDateTime = datetime.datetime.now() 

	def __init__(self, eventId, orderNumber, shipmentNumber):
		self.actualRecipientNameEvents = (0XA1004, 0XA1076, 0XA1077, 0XA1078, 0XA1079, 0XA1085, 0XA1090)
		self.PickupInfoEvents = (0XA1081, 0XA1082, 0XA1083)
		self.incomingPaymentEvents = (0X62012,)

		self.e_type_id = int('0X'+eventId, 16)
		self.e_flowid = '4740'
		self.e_instance_id = '(select li_id from zel_data.log_instance order by li_id desc limit 1)'
		self.e_value1 = orderNumber
		self.e_value2 = shipmentNumber
		self.e_value3 = 'DHL'
		self.e_value4 = 'DE'
		self.e_value5 = '%s%s'%(orderNumber, shipmentNumber)
		self.e_value6 = 'Original Carrier Code'
		self.e_value7 = 'custerFullName'
		self.e_value8 = 'hubInfo_Ruedorfs'
		self.e_value9 = 'the actual recipient'

	def getNextDateTime(self):
		delta = datetime.timedelta(hours=1)
		Event.usableDateTime = Event.usableDateTime + delta
		return Event.usableDateTime.strftime('%Y-%m-%d %H:%M:%S')
				
	def __getattr__(self, name):
		if 'e_value9' == name and self.actualRecipientNameEvents.__contains__(self.e_type_id):
			return 'actual recipient name'
		if 'e_value3' == name and self.incomingPaymentEvents.__contains__(self.e_type_id):
			return 'PAID'
		elif 'e_value9' == name  and self.PickupInfoEvents.__contains__(self.e_type_id):
			return 'some postoffice address'
		elif name == 'e_time':
			return self.getNextDateTime()
		else:
			return self[name]

	def __setattr__(self, name, value):
		self[name] = value 


def getData(node):
	return node.childNodes[0].data

def forEvent(event):
	nulls = ", null"*11;
	sql = "select zel_api.insert_event(TIMESTAMP '%s', %s, %s, '%s', '%s', '%s', '%s', '%s','%s','%s', '%s','%s','%s'%s);" %(event.e_time, event.e_type_id, event.e_instance_id, event.e_flowid, event.e_value1, event.e_value2, event.e_value3, event.e_value4, event.e_value5, event.e_value6, event.e_value7, event.e_value8, event.e_value9, nulls)

	return sql


def handleShipment(shipment, orderNumber, shipmentNumber):
	events = shipment.getElementsByTagName('events')[0].getElementsByTagName('event')
	print("\nGenerating SQL statements to create events for Order:%s and Shipment:%s"%(orderNumber,shipmentNumber))
	for event in events:
		eventId = getData(event.getElementsByTagName('id')[0])
		print("\n")
		print(forEvent(Event(eventId, orderNumber , shipmentNumber)))
	print("\n")

def handleDocument(document):

	tracking = document.getElementsByTagName("tracking")
	if tracking == None or len(tracking) != 1 :
		print("Invalid Shipment tracking document")
		return

	os.system("clear")
	testCaseId = raw_input('Please enter the Test case Id to run:')
	found = False

	for order in tracking[0].getElementsByTagName("order"):
		if order.getAttribute("test-case") == testCaseId:
			orderNumber = raw_input('Please enter the Order Number of the Order being  tested:')
			shipments  = order.getElementsByTagName("shipment")
			shipmentCount = 0;
			for shipment in shipments:
				shipmentCount = shipmentCount + 1
				shipmentNumber = raw_input('Shipment number for Shipment(%s) being tested:'%shipmentCount)
				handleShipment(shipment, orderNumber, shipmentNumber)
			return
	if not found:
		print("No Test case '%s' found."%testCaseId)


if __name__ == "__main__":
	file = os.path.join('shipment-tracking-test-cases.xml')
	document = parse(file)
	handleDocument(document) 
