package com.student_reg.demo.course;

import com.student_reg.demo.student.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_catalogue")
public class Course {

    private String courseID;

    private int courseUniqueID;

    public Course() {
    }

    public Course(String courseID) {
        this.courseID = courseID;
    }

    public Course(String courseID, int courseUniqueID) {
        this.courseID = courseID;
        this.courseUniqueID = courseUniqueID;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Id
    public int getCourseUniqueID() {
        return this.courseUniqueID;
    }

    public void setCourseUniqueID(int courseUniqueID) {
        this.courseUniqueID = courseUniqueID;
    }

}