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
----------------------------------------------------------------
insert into users(name,email) values ('Nag','nag@mail.com');
insert into users(name,email) values ('Indu','indu@mail.com');

insert into todos(title,completed,user_id) values ('todo1',false,1);
insert into todos(title,completed,user_id) values ('todo2',false,1);
insert into todos(title,completed,user_id) values ('todo3',true,1);
insert into todos(title,completed,user_id) values ('todo4',false,2);

----------------------------------------------------------------
-- select all todos for user 'Nag'
SELECT t.id,t.title,t.completed,t.user_id
FROM users u
         INNER JOIN todos t
                    on u.id=t.user_id AND u.name='Nag'
----------------------------------------------------------------