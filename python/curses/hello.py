
import curses
import time
stdscr = curses.initscr()
curses.cbreak()
stdscr.keypad(1)

try:
	# Run your code here
	stdscr.addch(10,5,"X")
	stdscr.refresh()
	time.sleep(3)
finally:
	curses.nocbreak()
	stdscr.keypad(0)
	curses.echo()
	curses.endwin()

