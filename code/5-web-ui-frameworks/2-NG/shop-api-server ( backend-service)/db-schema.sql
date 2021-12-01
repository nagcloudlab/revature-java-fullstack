

create database shopdb;
use shopdb;

create table products(
    id int primary key auto_increment,
    name varchar(100),
    price double,
    description longtext,
    is_available boolean,
    image_path varchar(100),
    make_date date
);

create table reviews(
    id int primary key auto_increment,
    author varchar(100),
    stars int,
    body longtext,
    product_id int references products
);


insert into products(name,price,description,is_available,image_path,make_date)
values ('Laptop',10000,'New Pro',true,'assets/laptop.png','2017-06-15')


insert into products(name,price,description,is_available,image_path,make_date)
values ('Mobile',10000,'New Pro',true,'assets/mobile.png','2017-06-15')


insert into reviews(author,stars,body,product_id) values('who1',5,'good laptop',1);
insert into reviews(author,stars,body,product_id) values('who2',2,'bad laptop',1);


insert into reviews(author,stars,body,product_id) values('who1',3,'good mobile',2);