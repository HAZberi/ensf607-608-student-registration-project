package com.student_reg.demo.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Date;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "student")
public class Student {

    private int StudentID;

    public String StudentName;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    public Student() {
    }

    public Student(String StudentName, String password) {
        this.setStudentName(StudentName);
        this.setPassword(password);
    }

    public Student(int StudentID, String StudentName, String password) {
        this.setStudentID(StudentID);
        this.setStudentName(StudentName);
        this.setPassword(password);
    }

    public Student(int StudentID, String StudentName, String password, Date dob) {
        this.setStudentID(StudentID);
        this.setStudentName(StudentName);
        this.setPassword(password);
        this.setDob(dob);
    }

    @Id
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    @Column(name = "StudentName")
    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    @Column(name = "pass_word")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "DateOfBirth")
    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + StudentID +
                ", StudentName='" + StudentName + "'" +
                '}';
    }

    @Autowired
    StudentRepository studentRespository;

}