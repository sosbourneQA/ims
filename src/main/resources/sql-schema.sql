create database if not exists ims;

create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));

create table if not exists ims.items(id int primary key auto_increment, name varchar(40), price double);

CREATE TABLE if not exists ims.orders(order_id int primary key auto_increment not null, customer_id int NOT NULL, 
total_price double NOT NULL, FOREIGN KEY (customer_id) REFERENCES customers (id) on delete cascade);


