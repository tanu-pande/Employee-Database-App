CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    designation VARCHAR(100),
    salary DOUBLE
);
