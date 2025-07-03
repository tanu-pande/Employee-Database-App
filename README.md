# Java JDBC - Employee Database App

## 📌 Objective
A simple Java CLI application to perform **CRUD operations** on an employee database using **JDBC and MySQL**.

## 🛠️ Tools Used
- Java
- MySQL
- JDBC Driver
- VS Code / IntelliJ

## ✅ Features
- Add employee
- View all employees
- Update employee details
- Delete employee record

## 🏁 How to Run
1. **Set up MySQL:**
   CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    designation VARCHAR(100),
    salary DOUBLE
);
2.Compile Java file:
javac EmployeeDBApp.java

3.Run Java app with JDBC driver:
java -cp .;mysql-connector-java-8.0.33.jar EmployeeDBApp

## Sample Output
![image_alt]()
![image_alt]()
![image_alt]()
