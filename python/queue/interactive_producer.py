import pika
connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()
channel.queue_declare(queue='hello')
#while True:
x=input("%")
channel.basic_publish(exchange='', routing_key='hello', body=str(x))
connection.close()
