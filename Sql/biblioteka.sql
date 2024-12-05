CREATE DATABASE Biblioteka;
USE Biblioteka;
-- ALTER DATABASE Biblioteka READ ONLY = 0;


CREATE TABLE jobs (
    job_id INT PRIMARY KEY,
    job_title VARCHAR(50) NOT NULL
);

create table employees(
	employee_id int primary key,
    user_id int unique,
    FOREIGN KEY (user_id) REFERENCES user(usser_id),
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

create table user(
	user_id int primary key,
    login varchar(50) unique not null,
    password varchar(50) not null,
    email varchar(50) unique not null,
    phone_number varchar(9),
	admin boolean default false
);


CREATE TABLE Books(
	book_id int AUTO_INCREMENT PRIMARY KEY, 
    title varchar(50),
    author varchar(50),
    publication_date date,
    publishing_house varchar(50),
    isbn varchar(50) unique
);

Create Table loans(
	loan_id int auto_increment primary key,
	book_id int,
    usser_id int,
    rental_date date not null,
    return_date date,
    primary key (book_id, usser_id),
    foreign key (book_id) references books(book_id),
    foreign key (usser_id) references usser(usser_id)
);

Create Table reservation(
    reservation_id int auto_increment primary key,
	book_id int ,
    usser_id int,
    reservation_date date,
	reservation_end_date date,
	primary key (book_id, usser_id),
    foreign key (book_id) references books(book_id),
    foreign key (usser_id) references usser(usser_id)
);

insert into books
values(2, "Imie Róży", "Umberto Eco", "2024-12-11", "Noir");

select * from Ksiazki;

-- DROP DATABASE Biblioteka;