CREATE table books(
book_id int primary key,
title varchar(50),
author varchar(50),
quantity int
);

CREATE table users (
user_id int primary key,
name varchar(50),
type varchar(10)
);


CREATE TABLE issued_books(
issue_id int primary key,
user_id int
book_id int,
issue_date TIMESTAMP,
return_date TIMESTAMP,
FOREIGN KEY (book_id) REFERENCES books(book_id),
FOREIGN KEY (user_id) REFERENCES users(user_id)
);

