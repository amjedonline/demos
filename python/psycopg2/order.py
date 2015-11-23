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
zonfig.dbhost = 'shop.release.db.zalando' 	
zonfig.user = 'mchand'
zonfig.password = 'Platform1317New'
zonfig.sharddb = 'release_customeridx_db' 
zonfig.port = 5432
zonfig.customerDbPattern = "release_customer%s_db"
zonfig.shopDb = 'release_shop_db'

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

class NoConfigFoundException(Exception):
	pass




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
# update zc_data.order SET o_gross_retail_total=0, o_gross_discounted_total=0, o_grand_total=0, o_open_amount=0, o_gross_credit_account_payment_total = 0, o_tax_total=0 where o_order_number='10105052583252';

	try:
		automation.execute("UPDATE zc_data.order SET o_shipping_status = 'COMPLETED', o_is_return_label_attached = false WHERE o_order_number = '%s'" %(orderId))
		print 'Updated the order'
		order = automation.fetchall("select * from zc_data.order where o_order_number = '%s'" %(orderId))
		pprint.pprint(order)
	except Exception, e:
		print 'Not able to update the Order to complete'
		print traceback.format_exc()


def insertAppConfig(appDomain, key, value):
	if key == None or value == None or appDomain == None:
		raise Exception('Key, Value or AppDomain could not be null')

	automation = OrderAutomation(zonfig.dbhost, zonfig.shopDb, zonfig.user, zonfig.password, zonfig.port)
	try:
		automation.execute("INSERT INTO zs_data.app_config \
			(ac_appdomain_id, ac_key, ac_value, ac_is_online_updateable) \
		    VALUES (%s, '%s', '%s', TRUE)" %(appDomain, key, value))
		print 'The Config was created successfuly'
	except Exception, e:
		print 'Not able to create the configuration'
		print traceback.format_exc()

def updateAppConfig(appDomain, key, value):
	if key == None or value == None or appDomain == None:
		raise Exception('Key, Value or AppDomain could not be null')

	automation = OrderAutomation(zonfig.dbhost, zonfig.shopDb, zonfig.user, zonfig.password, zonfig.port)
	try:
		automation.execute("UPDATE zs_data.app_config SET ac_value = '%s' \
			WHERE ac_appdomain_id = %s AND ac_key = '%s'" %(value, appDomain, key))
		print 'The Config was updated successfuly'
	except Exception, e:
		print 'Not able to update the configuration'
		print traceback.format_exc()


def showAppConfig(appDomain, key):
	if key == None or appDomain == None:
		raise Exception('Key, Value or AppDomain could not be null')

	automation = OrderAutomation(zonfig.dbhost, zonfig.shopDb, zonfig.user, zonfig.password, zonfig.port)
	try:
		config = automation.fetchall("SELECT * FROM zs_data.app_config WHERE ac_appdomain_id='%s' AND ac_key='%s'" %(appDomain,key))
		pprint.pprint(config)
	except Exception,e:
		print 'Could not fetch the configuration'
		print traceback.format_exc()

def getAppConfig(appDomain, key):
	if key == None or appDomain == None:
		raise Exception('Key, Value or AppDomain could not be null')

	automation = OrderAutomation(zonfig.dbhost, zonfig.shopDb, zonfig.user, zonfig.password, zonfig.port)
	config = []
	try:
		config = automation.fetchall("SELECT * FROM zs_data.app_config WHERE ac_appdomain_id='%s' AND ac_key='%s'" %(appDomain,key))
	except Exception,e:
		print 'Could not fetch the configuration'
	if len(config) == 0:
		raise NoConfigFoundException('No Config with that key exist')
	return config[0][3]	

def insertOrUpdateConfig(appDomain, key, value):
	try:
		exist_value = getAppConfig(appDomain,key)
		print 'Existing value: %s' %(exist_value)
		if exist_value != value:
			updateAppConfig(appDomain, key, value)
		else:
			print 'The key is already configured with this value, doing Nop...'
			pass
			
	except NoConfigFoundException, ncf:
		print 'No configuration with that key found, creating a new configuration'
		insertAppConfig(appDomain, key, value)

if __name__ == "__main__":
	print getCustomerShard('maverick@zalando.de')
	completeOrder('maverick@zalando.de', '10410012734720')
	#print getAppConfig(16, 'onlineretoure.pickup.step.active');
	#insertAppConfig(16, 'onlineretoure.pickup.step.active','true')
	#showAppConfig(16, 'onlineretoure.pickup.step.active');
	#showAppConfig(16, 'onlineretoure.pickup.choose.step.active');
	#insertOrUpdateConfig(16, 'onlineretoure.pickup.choose.step.active', 'true');
