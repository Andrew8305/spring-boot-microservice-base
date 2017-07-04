
-- create database
create database drjoy encoding utf8

-- change database
\c drjoy

-- users table
create table users (
  id int primary key,
  password varchar(16) not null,
  email text not null,
  name varchar(32) not null,
  surname varchar(32) not null
);

-- insert
insert into users (id, password, email, name, surname) values (1, 'aaa', 'aaa@nogizaka.com', '秋元', '真夏');
insert into users (id, password, email, name, surname) values (2, 'bbb', 'bbb@nogizaka.com', '生田', '絵梨花');
insert into users (id, password, email, name, surname) values (3, 'ccc', 'ccc@nogizaka.com', '生駒', '里奈');
insert into users (id, password, email, name, surname) values (4, 'ddd', 'ddd@nogizaka.com', '伊藤', '万理華');
insert into users (id, password, email, name, surname) values (5, 'eee', 'eee@nogizaka.com', '井上', '小百合');
insert into users (id, password, email, name, surname) values (6, 'fff', 'fff@nogizaka.com', '衛藤', '美彩');
insert into users (id, password, email, name, surname) values (7, 'ggg', 'ggg@nogizaka.com', '川後', '陽菜');
insert into users (id, password, email, name, surname) values (8, 'hhh', 'hhh@nogizaka.com', '川村', '真洋');
insert into users (id, password, email, name, surname) values (9, 'iii', 'iii@nogizaka.com', '齋藤', '飛鳥');
