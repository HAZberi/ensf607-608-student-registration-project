DROP DATABASE IF EXISTS STUDENTREGISTRATIONSYSTEM;
CREATE DATABASE STUDENTREGISTRATIONSYSTEM; 
USE STUDENTREGISTRATIONSYSTEM;

DROP TABLE IF EXISTS STUDENT;
CREATE TABLE STUDENT (
	StudentName				varchar(30)	not null,
	StudentID				integer not null,
--     DateOfBirth		date not null,
	primary key (StudentID)
);

INSERT INTO STUDENT (StudentName, StudentID)
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


DROP TABLE IF EXISTS COURSE_CATALOGUE;
CREATE TABLE COURSE_CATALOGUE (
	CourseID		varchar(30) not null,
    PreReq1 			varchar(30),
    PreReq2 			varchar(30),
    PreReq3 			varchar(30),
	primary key (CourseID)
-- 	foreign key (Country) references COUNTRY(CName)    
);

INSERT INTO COURSE_CATALOGUE (CourseID,PreReq1,PreReq2,PreReq3)
VALUES
('Course 001',null,null,null),
('Course 002',null,null,null),
('Course 003',null,null,null),
('Course 004',null,null,null),
('Course 005',null,null,null),
('Course 006','Course 001',null,null),
('Course 007','Course 001','Course 002',null),
('Course 008','Course 003','Course 004','Course 005'),
('Course 009',null,null,null),
('Course 010',null,null,null);

DROP TABLE IF EXISTS STUDENTCOURSES;
CREATE TABLE STUDENTCOURSES (
	StudentID			integer,
	Studentcourse1		varchar(20),
	Studentcourse2		varchar(20),
    Studentcourse3		varchar(20),
    Studentcourse4 		varchar(20),
    Studentcourse5		varchar(20),
    Studentcourse6		varchar(20),
	
	primary key (StudentID),
 	foreign key (StudentID) references STUDENT(StudentID)
);

INSERT INTO STUDENTCOURSES(StudentID,Studentcourse1,Studentcourse2,Studentcourse3,Studentcourse4,Studentcourse5,Studentcourse6)
VALUES
('1000000001','Course 001','Course 002','Course 003','Course 004','Course 005',null),
('1000000002','Course 001','Course 007','Course 010',null,null,null),
('1000000003','Course 001','Course 002','Course 004','Course 006',null,null),
('1000000004','Course 001','Course 002','Course 003','Course 004','Course 005','Course 006'),
('1000000005','Course 002','Course 003','Course 004','Course 008','Course 009',null),
('1000000006','Course 001','Course 002','Course 003','Course 004',null,null),
('1000000007','Course 006','Course 008','Course 010',null,null,null),
('1000000008','Course 001','Course 002','Course 003','Course 004','Course 005',null),
('1000000009','Course 001','Course 002','Course 003','Course 004','Course 005','Course 007'),
('1000000010','Course 005','Course 006','Course 007','Course 008','Course 009',null)
;

DROP TABLE IF EXISTS OFFERINGS;
CREATE TABLE OFFERINGS (
-- 	uniqueid 	varchar(30) not null,
	CourseID		varchar(30) not null,
	SectionNo		integer,
	-- primary key (CourseID),
	foreign key (CourseID) references COURSE_CATALOGUE(CourseID)
);

INSERT INTO OFFERINGS (CourseID, SectionNo)
VALUES
('Course 001',1),
('Course 001',2),
('Course 001',3),
('Course 002',1),
('Course 002',2),
('Course 002',3),
('Course 003',1),
('Course 003',2),
('Course 004',1),
('Course 004',2),
('Course 005',1),
('Course 005',2),
('Course 006',1),
('Course 007',1),
('Course 007',2),
('Course 008',1),
('Course 009',1),
('Course 010',1);


