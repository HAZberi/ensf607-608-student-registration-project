package com.student_reg.demo.student;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student")
public class Student {

    private int studentId;

    public String StudentName;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    public Student() {
    }

    public Student(int studentId) {
        this.setStudentId(studentId);
    }

    public Student(String StudentName, String password) {
        this.setStudentName(StudentName);
        this.setPassword(password);
    }

    public Student(int studentId, String StudentName, String password) {
        this.setStudentId(studentId);
        this.setStudentName(StudentName);
        this.setPassword(password);
    }

    public Student(int studentId, String StudentName, String password, Date dob) {
        this.setStudentId(studentId);
        this.setStudentName(StudentName);
        this.setPassword(password);
        this.setDob(dob);
    }

    @Id
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    private Set<RegisteredCourses> RegisteredCourses;

    @JsonManagedReference(value = "student-regcourse")
    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<RegisteredCourses> getRegisteredCourses() {
        return this.RegisteredCourses;
    }

    public void setRegisteredCourses(Set<RegisteredCourses> RegisteredCourses) {
        this.RegisteredCourses = RegisteredCourses;
    }

    // @Override
    // public String toString() {
    // return "Student{" +
    // "id=" + studentId +
    // ", StudentName='" + StudentName + "'" +
    // '}';
    // }

}