DROP DATABASE IF EXISTS petsrus;
CREATE DATABASE petsrus;
USE petsrus;

CREATE TABLE Product(
id INTEGER(10),
name varchar(300),
price DECIMAL(65, 2), 
type ENUM ('food', 'toy', 'other') NOT NULL,  
category ENUM ('dog', 'cat', 'reptile') NOT NULL,  	
page_url varchar(200),
image_url varchar(200),
summary varchar(1500),
description varchar(3000),
benefits varchar(3000),
PRIMARY KEY (id)
);

CREATE TABLE OrderDetails(
	order_num INTEGER(10),
    price DECIMAL(65, 2), 
	product_id INTEGER(10),
	qty INTEGER(100),
	fname varchar(30),
	lname varchar(30),
	email varchar(80),
	phone varchar(12),  
	address varchar(80),
	state varchar(30),
	city varchar(80),
	zip INTEGER(5),			
	shipping_option ENUM('overnight', 'expedited', 'ground'),
	cc_num varchar(19),		
	csc_num INTEGER(3),		
	card_type ENUM('VISA', 'Mastercard', 'American Express'),
	PRIMARY KEY (order_num),
	FOREIGN KEY (product_id) REFERENCES Product(id) ON DELETE NO ACTION
);
    
CREATE TABLE StateZip(
	zip INTEGER(5),
    state varchar(30),
	city varchar(80),
    PRIMARY KEY (zip)
);
    
CREATE TABLE TaxRate(
    state varchar(30),
	zip INTEGER(5),
	tax_region varchar(100),
	rate DECIMAL(3,2),
    PRIMARY KEY (zip)
);







