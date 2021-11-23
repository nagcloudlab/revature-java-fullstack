create database todosdb;
use todosdb;
---------------------------------------------------------------
CREATE TABLE users(
                      id int PRIMARY KEY auto_increment,
                      name varchar(100) NOT NULL,
                      email varchar(100)
);

CREATE TABLE todos(
                      id int PRIMARY KEY auto_increment,
                      title varchar(100) NOT NULL,
                      completed boolean,
                      user_id int REFERENCES users
);
