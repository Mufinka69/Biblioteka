CREATE DATABASE Biblioteka;
USE Biblioteka;
-- ALTER DATABASE Biblioteka READ ONLY = 0;


CREATE TABLE jobs (
    job_id INT PRIMARY KEY,
    job_title VARCHAR(50) NOT NULL
);

create table users(
	user_id int primary key,
    login varchar(50) unique not null,
    password varchar(50) not null,
    email varchar(50) unique not null,
    phone_number varchar(9),
	admin boolean default false
);

create table roles(
	role_id int,
    role_name varchar(50)
);

create table employees(
	employee_id int primary key,
    user_id int unique,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) unique,
    phone_number varchar(9) not null,    
    job_id int not null,
    hire_date date,
    end_date date
);

create table customer(
	customer_id int primary key,
    user_id int unique,
	FOREIGN KEY (user_id) REFERENCES user(user_id),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
	email varchar(50) unique,
    phone_number varchar(9)  
);


CREATE TABLE Books(
	book_id int PRIMARY KEY, 
    title varchar(50),
    author varchar(50),
    publication_date date,
    publishing_house varchar(50),
    isbn varchar(50) unique
);

Create Table reservation(
    reservation_id int auto_increment primary key,
	book_id int ,
    user_id int,
    reservation_date date,
	reservation_end_date date,
	-- primary key (book_id, user_id),
    foreign key (book_id) references books(book_id),
    foreign key (user_id) references user(user_id)
);

Create Table loans(
	loan_id int auto_increment primary key,
	book_id int,
    user_id int,
    rental_date date not null,
    return_date date,
    -- primary key (book_id, user_id),
    foreign key (book_id) references books(book_id),
    foreign key (user_id) references user(user_id)
);

insert into Books
values(1, "Imie Róży", "Umberto Eco", "2024-12-11", "Noir", "1234567");

select * from Books;

DROP DATABASE Biblioteka;