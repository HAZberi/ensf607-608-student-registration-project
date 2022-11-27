DROP DATABASE IF EXISTS STUREGDB;
CREATE DATABASE STUREGDB; 
USE STUREGDB;

DROP TABLE IF EXISTS STUDENT;
CREATE TABLE STUDENT (
	StudentName				varchar(30)	not null,
	StudentID				int auto_increment,
	DateOfBirth				date not null,
	Pass_word				varchar(30) not null,
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
	CourseUniqueID		int auto_increment,
	CourseID		varchar(30) not null,
	primary key (CourseUniqueID)
);

INSERT INTO COURSE_CATALOGUE (CourseID)
VALUES
('Course 001'),
('Course 002'),
('Course 003'),
('Course 004'),
('Course 005'),
('Course 006'),
('Course 007'),
('Course 008'),
('Course 009');

DROP TABLE IF EXISTS PreReqs;
CREATE TABLE PreReqs (
    PreReqID		int,
    Course			int,
    PreReq			int,
	primary key (PreReqID),
    foreign key (Course) references COURSE_CATALOGUE(CourseUniqueID),
    foreign key (PreReq) references COURSE_CATALOGUE(CourseUniqueID)
);

INSERT INTO PreReqs (PreReqID, Course, PreReq)
VALUES
(1, 6, 1),
(2, 6, 2),
(3, 7, 1),
(4, 8, 3);


DROP TABLE IF EXISTS OFFERINGS;
CREATE TABLE OFFERINGS (
 	uniqueid 	integer not null,
	CourseID		integer,
	SectionNo		integer,
    Capacity 	integer,
	primary key (uniqueid),
	foreign key (CourseID) references COURSE_CATALOGUE(CourseUniqueID)
);

INSERT INTO OFFERINGS (uniqueid,CourseID, SectionNo,Capacity)
VALUES
(1,1,1,19),
(2,1,2,14),
(3,2,1,18),
(4,2,2,18),
(5,3,1,18),
(6,3,2,18),
(7,3,3,23),
(8,4,1,23),
(9,5,1,20),
(10,6,1,19),
(11,7,1,13),
(12,8,1,18),
(13,9,1,12);

DROP TABLE IF EXISTS REGISTEREDCOURSES;
CREATE TABLE REGISTEREDCOURSES (
	StudentID			integer NOT NULL,
	OfferingID			integer NOT NULL,
	
 	foreign key (OfferingID) references OFFERINGS(uniqueid),
    foreign key (StudentID) references STUDENT(StudentID)
    
);

INSERT INTO REGISTEREDCOURSES(StudentID,OfferingID)
VALUES
('1000', 1),('1001', 1),('1002', 2),('1003', 1),('1004', 1),('1005', 1),('1006', 1),('1007', 1),('1008', 1),('1010', 1),('1013', 1),('1015', 1),
('1000', 2),('1001', 3),('1002', 3),('1003', 2),('1004', 3),('1005', 3),('1006', 3),('1007', 4),('1008', 4),('1010', 4),('1013', 4),('1015', 4),
('1000', 5),('1001', 10),('1002', 11),('1003', 4),('1004', 4),('1005', 5),('1006', 10),('1007', 3),('1008', 11),('1010', 3),('1013', 3),('1015', 3),
('1000', 6),('1001', 11),('1002', 12),('1003', 5),('1004', 5),('1005', 6),('1006', 11),('1007', 5),('1008', 12),('1010', 2),('1013', 8),('1015', 5),
('1000', 7),('1001', 12),('1002', 13),('1003', 6),('1004', 6),('1005', 7),('1006', 12),('1007', 6),('1008', 13),('1010', 10),('1013', 7),('1015', 6),
('1000', 8),('1001', 13),('1002', 4),('1003', 7),('1004', 7),('1005', 8),('1006', 13),('1007', 8),('1008', 3),('1010', 11),('1013', 6),('1015', 7),
('1000', 9),('1001', 4),('1002', 4),('1003', 8),('1004', 8),('1005', 9),('1006', 4),('1007', 13),('1008', 10),('1010', 13),('1013', 5),('1015', 8);


