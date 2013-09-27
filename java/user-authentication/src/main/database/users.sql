

DROP DATABASE IF EXISTS sampleusers;
CREATE DATABASE sampleusers;
USE sampleusers;
CREATE TABLE users (
username varchar(20) NOT NULL PRIMARY KEY,
password varchar(20) NOT NULL
);

CREATE TABLE roles (
rolename varchar(20) NOT NULL PRIMARY KEY
);

CREATE TABLE users_roles (
username varchar(20) NOT NULL,
rolename varchar(20) NOT NULL,
PRIMARY KEY (username, rolename),
CONSTRAINT users_roles_fk1 FOREIGN KEY (username) REFERENCES users (username),
CONSTRAINT users_roles_fk2 FOREIGN KEY (rolename) REFERENCES roles (rolename)
);

INSERT INTO `sampleusers`.`users` (`username`, `password`) VALUES ('amjed', 'amjedonline');
INSERT INTO `sampleusers`.`roles` (`rolename`) VALUES ('user');
INSERT INTO `sampleusers`.`users_roles` (`username`, `rolename`) VALUES ('amjed', 'user');
COMMIT;