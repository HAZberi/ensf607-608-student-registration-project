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
('David Senior','2000-06-11','abc');

DROP TABLE IF EXISTS COURSE_CATALOGUE;
CREATE TABLE COURSE_CATALOGUE (
	CourseUniqueID		int auto_increment,
	CourseID		varchar(30) not null,
	primary key (CourseUniqueID)
);

INSERT INTO COURSE_CATALOGUE (CourseID)
VALUES
('ENSF 612'),
('ENSF 609'),
('ENCM 400'),
('ENGG 200'),
('MATH 211'),
('CPSC 512'),
('ARTS 209'),
('ENGG 243'),
('CHEM 209');

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
 	OfferingID 		int auto_increment,
	CourseID		integer,
	SectionNo		integer,
    Capacity 		integer,
	primary key (OfferingID),
	foreign key (CourseID) references COURSE_CATALOGUE(CourseUniqueID)
);

INSERT INTO OFFERINGS (CourseID, SectionNo,Capacity)
VALUES
(1,1,19),
(1,2,14),
(2,1,18),
(2,2,18),
(3,1,18),
(3,2,18),
(3,3,23),
(4,1,23),
(5,1,20),
(6,1,19),
(7,1,13),
(8,1,18),
(9,1,12);

DROP TABLE IF EXISTS REGISTEREDCOURSES;
CREATE TABLE REGISTEREDCOURSES(
	RegisteredID		int auto_increment,
	StudentID			integer NOT NULL,
	OfferingID			integer NOT NULL,
	
    primary key (RegisteredID),
 	foreign key (OfferingID) references OFFERINGS(OfferingID),
    foreign key (StudentID) references STUDENT(StudentID)
);

INSERT INTO REGISTEREDCOURSES(StudentID,OfferingID)
VALUES
('1000', 1),('1001', 1),('1002', 1),('1003', 1),('1004', 1),('1005', 1),('1006', 1),('1007', 1),('1008', 1),('1010', 1),('1013', 1),('1015', 1),
('1000', 4),('1001', 4),('1002', 4),('1003', 4),('1004', 4),('1005', 4),('1006', 4),('1007', 4),('1008', 5),('1010', 5),('1013', 5),('1015', 5),
('1000', 8),('1001', 8),('1002', 8),('1003', 9),('1004', 9),('1005', 9),('1006', 9),('1007', 9),('1008', 10),('1010', 10),('1013', 10),('1015', 10),
('1000', 11),('1001', 11),('1002', 11),('1003', 11),('1004', 12),('1005', 12),('1006', 12),('1007', 12),('1008', 13),('1010', 13),('1013', 13),('1015', 13);


