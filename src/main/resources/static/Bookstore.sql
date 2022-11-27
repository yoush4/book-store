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
	book_id int not null auto_increment,
    book_name varchar(20),
    author varchar(20),
    price int not null,
    category varchar(20),
    book_likes int default null,
    log timestamp default current_timestamp,
    primary key(book_id)
    );
create table rented(
	user_id int not null,
    bookId int not null,
    amount int not null,
    issueDateTime timestamp,
    returnDateTime timestamp,	
    foreign key(bookId) REFERENCES book(book_id),
    foreign key(user_id) REFERENCES user(user_id)
    );
create table review(
	user_id int not null,
    bookId int not null,
    review varchar(20),
	
    foreign key(bookId) REFERENCES book(book_id),
    foreign key(user_id) REFERENCES user(user_id)
    );

 create table bookCount(
	bookCopies int ,
    bookId int not null,
        foreign key(bookId) REFERENCES Book(book_id)
        );
        
        select * from user;
        