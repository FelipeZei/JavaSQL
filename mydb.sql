create database mydb;
use mydb;

CREATE USER 'sqluser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL ON *.* TO 'sqluser'@'localhost' WITH GRANT OPTION;

CREATE TABLE product (
	id INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(30) NOT NULL,
    PRICE INT NOT NULL,
    DATUM DATE NOT NULL,
    PRIMARY KEY (ID)
);
