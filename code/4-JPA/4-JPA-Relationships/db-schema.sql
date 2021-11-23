create table employees (
                           e_id integer not null,
                           dob date,
                           gender varchar(255),
                           e_name varchar(100) not null,
                           profile longtext,
                           profilePic longblob,
                           primary key (e_id)
) engine=InnoDB