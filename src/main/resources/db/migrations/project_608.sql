DROP DATABASE IF EXISTS STUDENTREGISTRATIONSYSTEM;
CREATE DATABASE STUDENTREGISTRATIONSYSTEM; 
USE STUDENTREGISTRATIONSYSTEM;

DROP TABLE IF EXISTS STUDENT;
CREATE TABLE STUDENT (
	StudentName				varchar(30)	not null,
	StudentID				int auto_increment,
     DateOfBirth		date not null,
     Pass_word			varchar(30) not null,
	primary key (StudentID)
)auto_increment=1000;

INSERT INTO STUDENT (StudentName,DateOfBirth,Pass_word)
VALUES
('John Smith','1991-05-06','abc'),
('Aaron Warner','2002-01-02','abc'),
('Muhammad Fahad Hussain','1998-04-08','abc'),
('Jack McDonalds','2001-03-04','abc'),
('Hassaan Zuberi','1996-06-28','abc'),
('Michael Lee','1998-11-15','abc'),
('Aaryan Sharma','1998-10-19','abc'),
('Shahrukh Khan','1993-02-09','abc'),
('Brandon Sanders','1997-05-03','abc'),
('Ajay Kumar','2000-06-23','abc'),
('Lionel Messi','2000-02-18','abc'),
('Cristiano Ronaldo','2000-06-11','abc'),
('Neymar Junior','2001-03-12','abc'),
('Donald Williams','2000-04-25','abc'),
('Steve Jones','2002-11-12','abc'),
('David Senior','2000-06-11','abc')
;

DROP TABLE IF EXISTS COURSE_CATALOGUE;
CREATE TABLE COURSE_CATALOGUE (
	CourseID		varchar(30) not null,
    PreReq1 			varchar(30),
    PreReq2 			varchar(30),
    PreReq3 			varchar(30),
    checkifPrereqs		bit(1),
	primary key (CourseID)
);

INSERT INTO COURSE_CATALOGUE (CourseID,PreReq1,PreReq2,PreReq3,checkifPrereqs)
VALUES
('Course 001',null,null,null,0),
('Course 002',null,null,null,0),
('Course 003',null,null,null,0),
('Course 004',null,null,null,0),
('Course 005',null,null,null,0),
('Course 006','Course 001',null,null,1),
('Course 007','Course 001','Course 002',null,1),
('Course 008','Course 003','Course 004','Course 005',1),
('Course 009',null,null,null,0);

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
('1000','Course 001 Sec 1','Course 002 Sec 2','Course 003 Sec 1','Course 004 Sec 1','Course 005 Sec 1','Course 008 Sec 1'),
('1001','Course 001 Sec 1','Course 007 Sec 2','Course 010 Sec 1','Course 002 Sec 2','Course 003 Sec 1','Course 008 Sec 1'),
('1002','Course 001 Sec 1','Course 002 Sec 1','Course 004 Sec 1','Course 006 Sec 1','Course 003 Sec 1','Course 008 Sec 1'),
('1003','Course 001 Sec 1','Course 002 Sec 1','Course 003 Sec 1','Course 004 Sec 1','Course 005 Sec 1','Course 006 Sec 1'),
('1004','Course 002 Sec 2','Course 003 Sec 1','Course 004 Sec 1','Course 008 Sec 1','Course 009 Sec 1',null),
('1005','Course 001 Sec 1','Course 002 Sec 2','Course 003 Sec 2','Course 004 Sec 1','Course 008 Sec 1',null),
('1006','Course 006 Sec 1','Course 008 Sec 1','Course 010 Sec 1','Course 002 Sec 2','Course 003 Sec 2',null),
('1007','Course 001 Sec 3','Course 002 Sec 2','Course 003 Sec 2','Course 004 Sec 1','Course 005 Sec 1','Course 008 Sec 1'),
('1008','Course 001 Sec 2','Course 002 Sec 2','Course 003 Sec 2','Course 004 Sec 1','Course 005 Sec 1','Course 007 Sec 1'),
('1009','Course 001 Sec 2','Course 006 Sec 1','Course 003 Sec 1','Course 008 Sec 1','Course 009 Sec 1','Course 002 Sec 1'),
('1010','Course 001 Sec 1','Course 002 Sec 1','Course 003 Sec 2','Course 004 Sec 1','Course 005 Sec 1','Course 006 Sec 1'),
('1011','Course 001 Sec 2','Course 002 Sec 2','Course 003 Sec 1','Course 004 Sec 1','Course 005 Sec 1','Course 006 Sec 1'),
('1012','Course 001 Sec 1','Course 002 Sec 1','Course 003 Sec 2','Course 004 Sec 1','Course 005 Sec 1','Course 006 Sec 1'),
('1013','Course 001 Sec 2','Course 002 Sec 1','Course 003 Sec 2','Course 004 Sec 1','Course 005 Sec 1','Course 006 Sec 1'),
('1014','Course 001 Sec 1','Course 002 Sec 1','Course 003 Sec 1','Course 004 Sec 1','Course 005 Sec 1','Course 006 Sec 1'),
('1015','Course 001 Sec 2','Course 002 Sec 1','Course 003 Sec 2','Course 004 Sec 1','Course 005 Sec 1','Course 007 Sec 1');

DROP TABLE IF EXISTS OFFERINGS;
CREATE TABLE OFFERINGS (
 	uniqueid 	varchar(30) not null,
	CourseID		varchar(30) not null,
	SectionNo		integer,
    TotalStudents 	integer,
	#primary key (CourseID,SectionNo),
	foreign key (CourseID) references COURSE_CATALOGUE(CourseID)
);

INSERT INTO OFFERINGS (uniqueid,CourseID, SectionNo,TotalStudents)
VALUES
('Course 001 Sec 1','Course 001',1,9),
('Course 001 Sec 2','Course 001',2,4),
('Course 002 Sec 1','Course 002',1,8),
('Course 002 Sec 2','Course 002',2,8),
('Course 003 Sec 1','Course 003',1,8),
('Course 003 Sec 2','Course 003',2,8),
('Course 004 Sec 1','Course 004',1,13),
('Course 005 Sec 1','Course 005',1,10),
('Course 006 Sec 1','Course 006',1,9),
('Course 007 Sec 1','Course 007',1,3),
('Course 008 Sec 1','Course 008',1,8),
('Course 009 Sec 1','Course 009',1,2);


