
drop database booksdb;
create database booksdb;
use booksdb;

create table publishers(
   id int primary key auto_increment,
   name varchar(256)
);

create table books(
    id int primary key auto_increment,
    name varchar(256),
    author_name varchar(256),
    price double,
    description longtext,
    publisher_id int references publishers
);
