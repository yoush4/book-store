-- drop database bookStore; 
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
    books_rented int,
    primary key(user_id)
    );
    select * from user;
    select * from book;
    
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
	rented_id int not null auto_increment,
	user_id int not null,
    book_id int not null,
    issue_date_time timestamp default current_timestamp,
    return_date_time timestamp,	
    primary key(rented_id),
    foreign key(book_id) REFERENCES book(book_id),
    foreign key(user_id) REFERENCES user(user_id)
    );
    drop table rented;
create table review(
	review_id int not null auto_increment,
	user_id int not null,
    book_id int not null,
    review varchar(20),
	primary key(review_id),
    foreign key(book_id) REFERENCES book(book_id),
    foreign key(user_id) REFERENCES user(user_id)
    );
    select * from review;
    delete from review where review_id=1;
    
    -- drop table review;

 create table bookcount(
	book_copies int ,
    bookid int not null,
    primary key(bookid),
	foreign key(bookid) REFERENCES Book(book_id)
);

drop table bookcount;

select * from bookcount;
select * from user;
select * from book;
select * from review;

select * from rented;

select * from book;
select * from review;



        select * from bookcount;
INSERT INTO bookcount(bookid, book_copies) VALUES (4, 2);
INSERT INTO bookcount(bookid, book_copies) VALUES (3, 5);

        