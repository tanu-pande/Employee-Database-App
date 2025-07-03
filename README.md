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
![image_alt](https://github.com/tanu-pande/Employee-Database-App/blob/656f0d3a30facd956a4b15d80b1639305c484847/Screenshot%202025-07-03%20191046.png)
![image_alt](https://github.com/tanu-pande/Employee-Database-App/blob/b695cd607cbd32acc455427ec680e97d856954d9/Screenshot%202025-07-03%20191058.png)
![image_alt](https://github.com/tanu-pande/Employee-Database-App/blob/294341b785d2a83ad68d6b904b3dcb369c9a6d74/Screenshot%202025-07-03%20191119.png)

## Database:
![image_alt](https://github.com/tanu-pande/Employee-Database-App/blob/7286e0da2fcc6d32e4f451c16694c5cd5391b1ac/Screenshot%202025-07-03%20191225.png)
