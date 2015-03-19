# Tasks schema
# --- !Ups

CREATE SEQUENCE task_id_seq;
CREATE SEQUENCE user_id_seq;
CREATE SEQUENCE gitlog_id_seq;
CREATE TABLE user (
    user_id    integer DEFAULT nextval('user_id_seq') PRIMARY KEY ,
    email      varchar(255) NOT NULL UNIQUE,
    name       varchar(255) NOT NULL,
    password   varchar(255) NOT NULL
);
CREATE TABLE task (
	id integer NOT NULL DEFAULT nextval('task_id_seq'),
	label varchar(255),
	progress integer DEFAULT 0,
	target datetime DEFAULT null,
	seq integer,
	created datetime DEFAULT null,
	modified datetime DEFAULT null,
	user_id integer NOT NULL
	--FOREIGN KEY(user_id) REFERENCES user(user_id)
);
CREATE TABLE gitlog (
	id integer NOT NULL DEFAULT nextval('gitlog_id_seq'),
	label varchar(255),
	progress integer DEFAULT 0,
	target datetime DEFAULT null,
	seq integer,
	created datetime DEFAULT null,
	modified datetime DEFAULT null,
	user_id integer NOT NULL
	--FOREIGN KEY(user_id) REFERENCES user(user_id)
);

insert into user (email, name, password)
        values ('a@gmail.com', 'a', 'pass');


 insert into task (label,target,user_id,created) values ('task1','2015-01-20',1,'2015-01-10');
 insert into task (label,target,user_id,created) values ('task2','2015-01-25',1,'2015-01-11');
 insert into task (label,target,user_id,created) values ('task3','2015-01-21',2,'2015-01-12');
 insert into task (label,target,user_id,created) values ('task4','2015-01-24',2,'2015-01-13');

 insert into task (label,target,user_id,created) values ('task5','2015-01-26',1,'2015-01-01');
 insert into task (label,target,user_id,created) values ('task6','2015-01-27',1,'2015-01-02');
 insert into task (label,target,user_id,created) values ('task7','2015-01-28',2,'2015-01-03');
 insert into task (label,target,user_id,created) values ('task8','2015-01-29',2,'2015-01-04');


# --- !Downs
DROP TABLE task;
DROP TABLE if exists user;
DROP SEQUENCE task_id_seq;
DROP SEQUENCE if exists user_id_seq;