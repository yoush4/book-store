drop database bookStore; 
create database bookStore;
use bookStore;

-- drop table rented;
create table user(
	user_id int not null AUTO_INCREMENT,
    user_name varchar(20) unique,
    phone int not null unique,
    email varchar(20) unique,
    wallet int ,
    user_status boolean not null,
    primary key(user_id)
    );
    
create table book(
	bookId int not null,
    bookName varchar(20),
    author varchar(20),
    price int not null,
    category varchar(20),
    bookLikes boolean,
    log timestamp,
    primary key(bookId)
    );
create table rented(
	user_id int not null,
    bookId int not null,
    amount int not null,
    issueDateTime timestamp,
    returnDateTime timestamp,	
    foreign key(bookId) REFERENCES book(bookId),
    foreign key(user_id) REFERENCES user(user_id)
    );
create table review(
	user_id int not null,
    bookId int not null,
    review varchar(20),
	
    foreign key(bookId) REFERENCES book(bookId),
    foreign key(user_id) REFERENCES user(user_id)
    );

 create table bookCount(
	bookCopies int ,
    bookId int not null,
        foreign key(bookId) REFERENCES Book(bookId)
        );