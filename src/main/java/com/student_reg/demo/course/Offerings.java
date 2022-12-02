package com.student_reg.demo.course;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.student_reg.demo.student.RegisteredCourses;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Offerings {

    private int offeringId;

    private Course courseId;

    private int sectionNo;

    private int capacity;

    public Offerings() {
    }

    public Offerings(int offeringId) {
        this.offeringId = offeringId;
    }

    public Offerings(Course courseId, int sectionNo, int capacity) {
        this.courseId = courseId;
        this.sectionNo = sectionNo;
        this.capacity = capacity;
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

    @JsonBackReference(value = "course-offerings")
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

    private Set<RegisteredCourses> registeredCourses;

    @JsonManagedReference(value = "offerings-regcourse")
    @OneToMany(mappedBy = "offeringId", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<RegisteredCourses> getRegisteredCourses() {
        return this.registeredCourses;
    }

    public void setRegisteredCourses(Set<RegisteredCourses> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

}