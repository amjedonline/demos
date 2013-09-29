

DROP DATABASE IF EXISTS mydbrealm;
CREATE DATABASE mydbrealm;
USE mydbrealm;
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

INSERT INTO `mydbrealm`.`users` (`username`, `password`) VALUES ('amjed', 'amjedonline');
INSERT INTO `mydbrealm`.`roles` (`rolename`) VALUES ('user');
INSERT INTO `mydbrealm`.`users_roles` (`username`, `rolename`) VALUES ('amjed', 'user');
COMMIT;