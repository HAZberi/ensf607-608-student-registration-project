package com.student_reg.demo.course;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
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

    private Set<Offerings> offerings;

    @JsonManagedReference(value = "course-offerings")
    @OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Offerings> getOfferings() {
        return this.offerings;
    }

    public void setOfferings(Set<Offerings> offerings) {
        this.offerings = offerings;
    }

    private Set<PreReq> prereqMain;

    @JsonManagedReference(value = "course-prereqMain")
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<PreReq> getPrereqMain() {
        return this.prereqMain;
    }

    public void setPrereqMain(Set<PreReq> prereqMain) {
        this.prereqMain = prereqMain;
    }

    private Set<PreReq> prereq;

    @JsonManagedReference(value = "course-prereq")
    @OneToMany(mappedBy = "prereq", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<PreReq> getPrereq() {
        return this.prereq;
    }

    public void setPrereq(Set<PreReq> prereq) {
        this.prereq = prereq;
    }

}