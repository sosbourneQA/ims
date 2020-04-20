create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(id int primary key auto_increment, name varchar(40), int double);
create table if not exists ims.items1(id int primary key auto_increment, name varchar(40), price double);
create table if not exists ims.newitems(id int primary key auto_increment, name varchar(40), price double);