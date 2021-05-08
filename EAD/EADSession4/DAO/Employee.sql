CREATE DATABASE employee;
USE employee;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    date_of_birth
    DATE NOT NULL,
    contact_no VARCHAR(10) NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    organization VARCHAR(20) NOT NULL
);
