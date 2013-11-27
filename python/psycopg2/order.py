import psycopg2
import sys
import pprint

import traceback

class Config(dict):

	def __getattr__(self, name):
		return self[name]

	def __setattr__(self, name, value):
		self[name] = value

	
zonfig = Config()
zonfig.dbhost = 'shop.integration.db.zalando' 	
zonfig.user = 'mchand'
zonfig.password = ''
zonfig.sharddb = 'integration_customeridx_db' 
zonfig.port = 5432
zonfig.customerDbPattern = "integration_customer%s_db"

class OrderAutomation:
	def __init__(self, host, dbname, username, password, port):
		effective_port = port or 5432
		self.connectionString = "host='%s' port = '%s' user='%s' password='%s' dbname='%s'" %(host, effective_port, username, password, dbname)
		self.connection = psycopg2.connect(self.connectionString)
		pass

	def printConnectionSettings(self):
		print "******** Connection settings ********* \n%s\n" %(self.connectionString)

	def fetchall(self, statement):
		cursor = self.connection.cursor()
		cursor.execute(statement)
		records = cursor.fetchall()
		return records

	def fetchallInSchema(self, schema, statement):
		cursor = self.connection.cursor()
		cursor.execute("SET search_path TO %s" %(schema))
		cursor.execute(statement)
		records = cursor.fetchall()
		return records

	def execute(self, statement):
		cursor = self.connection.cursor()
		cursor.execute(statement)
		self.connection.commit()





def demo():
	automation = OrderAutomation('localhost', 'postgres', 'admin', '')
	automation.printConnectionSettings()
	records=automation.fetchall("SELECT * FROM cities")
	pprint.pprint(records)

def getCustomerShard(customerEmail):

	automation = OrderAutomation(zonfig.dbhost, zonfig.sharddb, zonfig.user, zonfig.password, zonfig.port)
	statement = "SELECT c_shard_index FROM zci_data.customer where c_email like '%s'" %(customerEmail, )

	#returns list of tuples
	records = automation.fetchall(statement)
	index = records[0][0]
	return index

def completeOrder(customerEmail, orderId):
	if orderId == None:
		raise Exception('An orderId is required to complete the order.')
	shardIndex = getCustomerShard(customerEmail)
	customerDb = zonfig.customerDbPattern %(shardIndex)
	automation = OrderAutomation(zonfig.dbhost, customerDb, zonfig.user, zonfig.password, zonfig.port)
	#order = automation.fetchall("select * from zc_data.order where o_order_number = '%s'" %(orderId))
	try:
		automation.execute("UPDATE zc_data.order SET o_shipping_status = 'COMPLETED', o_is_return_label_attached = false WHERE o_order_number = '%s'" %(orderId))
		print 'Updated the order'
		order = automation.fetchall("select * from zc_data.order where o_order_number = '%s'" %(orderId))
		pprint.pprint(order)
	except Exception, e:
		print 'Not able to update the Order to complete'
		print traceback.format_exc()

if __name__ == "__main__":
	#getCustomerShard('italy')
	completeOrder('italy@amjed.com', '10501010539424')
