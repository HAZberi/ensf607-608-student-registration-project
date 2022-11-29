#Show all courses
select * from course_catalogue;

#show all courses sorted by name
select * from course_catalogue
order by CourseId asc;

#get a course by name
select CourseID='Course 001' from COURSE_CATALOGUE;

#create a new course
INSERT INTO COURSE_CATALOGUE
VALUES(10,'Course 010');
select * from course_catalogue;

#edit a course name
Update COURSE_CATALOGUE
Set CourseID='Course 0002'
Where CourseUniqueID=2;

#removing a course
Delete from COURSE_CATALOGUE
Where CourseID='Course 1001' and CourseUniqueID = 1;
select * from course_catalogue;

#student registering for course
INSERT INTO REGISTEREDCOURSES
VALUES('1000',12);
select * from Registeredcourses;

#unregistering from course
DELETE FROM REGISTEREDCOURSES
Where StudentID='1000' and OfferingID='1';
select * from Registeredcourses;


SELECT CourseID FROM COURSE_CATALOGUE
JOIN COURSE_CATALOGUE on COURSE_CATALOGUE.CourseID = Offerings.CourseID
JOIN REGISTEREDCOURSES on RegisteredCourses.offeringID = Offerings.offeringID
where registeredcourses.offeringID = 1;

