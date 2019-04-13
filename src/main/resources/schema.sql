drop schema if exists sample cascade;
create schema sample;

--CREATE TYPE sample.title AS ENUM ('Mr', 'Mrs', 'Miss');
create TABLE sample.task
(
 id serial not null unique primary key,
 first_name varchar(100) NOT NULL,
 last_name varchar(100) NOT NULL ,
 scheduled_date timestamp not NULL,
 notes varchar(100) DEFAULT NULL,
 title varchar(100) not null,
 address_line_1 varchar(255) default null,
 address_line_2 varchar(255) default null,
city  varchar(255) default null,
 country varchar(255) default null,
  postcode varchar(255) default null

 );

