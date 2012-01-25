import pynotify

#notification = pynotify.Notification("Get to work", "Did you prepare the TODO today ? ");
#notification.show();
file = open("/home/amjed/scripts/py/ipy/message", "w");
file.write("Cron says hii");
file.close();
