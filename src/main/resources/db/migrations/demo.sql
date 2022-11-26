DROP DATABASE IF EXISTS DEMOSTUDENT;
CREATE DATABASE DEMOSTUDENT; 
USE DEMOSTUDENT;

DROP TABLE IF EXISTS STUDENT;
CREATE TABLE STUDENT (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Student_Name				varchar(30)	not null,
	StudentID				integer not null
);

INSERT INTO STUDENT (Student_Name, StudentID)
VALUES
('John Smith','1000000001'),
('Aaron Warner','1000000002'),
('Muhammad Fahad Hussain','1000000003'),
('Jack McDonalds','1000000004'),
('Hassaan Zuberi','1000000005'),
('Michael Lee','1000000006'),
('Aaryan Sharma','1000000007'),
('Shahrukh Khan','1000000008'),
('Brandon Sanders','1000000009'),
('Ajay Kumar','1000000010');
