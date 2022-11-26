package com.student_reg.demo.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Student {

    private int StudentID;

    private String StudentName;
   

    public Student() {  }

    public Student(int StudentID, String StudentName){
        this.setStudentID(StudentID);
        this.setStudentName(StudentName);
    }

    @Id
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    @Column(name="StudentName")
    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
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