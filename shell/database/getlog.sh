#!/bin/sh

mysql -uroot -proot -h127.0.0.1 semgel  < user.sql  > output.txt
