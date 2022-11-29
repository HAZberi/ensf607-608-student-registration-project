package com.student_reg.demo.course;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.student_reg.demo.student.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Offerings {

    private int offeringId;

    private Course courseId;

    private int sectionNo;

    private int capacity;

    public Offerings() {
    }

    public Offerings(int offeringId, Course courseId, int sectionNo, int capacity) {
        this.offeringId = offeringId;
        this.courseId = courseId;
        this.sectionNo = sectionNo;
        this.capacity = capacity;
    }

    @Id
    public int getOfferingId() {
        return this.offeringId;
    }

    public void setOfferingId(int offeringId) {
        this.offeringId = offeringId;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "courseId")
    public Course getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public int getSectionNo() {
        return this.sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private Set<RegisteredCourses> RegisteredCourses;

    @JsonManagedReference
    @OneToMany(mappedBy = "offeringId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<RegisteredCourses> getRegisteredCourses() {
        return this.RegisteredCourses;
    }

    public void setRegisteredCourses(Set<RegisteredCourses> RegisteredCourses) {
        this.RegisteredCourses = RegisteredCourses;
    }

}