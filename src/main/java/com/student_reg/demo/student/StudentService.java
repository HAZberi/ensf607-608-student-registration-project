package com.student_reg.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.student_reg.demo.course.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final RegisteredCoursesRepository registeredCoursesRepository;
    private final OfferingsRepository offeringsRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, RegisteredCoursesRepository registeredCoursesRepository,
            OfferingsRepository offeringsRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.registeredCoursesRepository = registeredCoursesRepository;
        this.offeringsRepository = offeringsRepository;
        this.courseRepository = courseRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByName = studentRepository.findByStudentName(student.getStudentName());
        if (studentByName.isPresent()) {
            throw new IllegalStateException("Student already exists!");
        }
        studentRepository.save(student);
    }

    public Student getStudentById(int studentId) {
        Optional<Student> studentById = studentRepository.findById(studentId);
        if (!studentById.isPresent()) {
            throw new IllegalStateException("Student doesn't exist!");
        }
        return studentById.get();
    }

    public Student getStudentByName(String studentName) {
        Optional<Student> studentByName = studentRepository.findByStudentName(studentName);
        if (!studentByName.isPresent()) {
            throw new IllegalStateException("Student doesn't exist!");
        }
        return studentByName.get();
    }

    public List<Course> registeredCourseList(int studentId) {
        Optional<Student> studentById = studentRepository.findById(studentId);
        if (!studentById.isPresent()) {
            throw new IllegalStateException("Student doesn't exist!");
        }
        Set<RegisteredCourses> studentRegCourses = studentById.get().getRegisteredCourses();
        List<Offerings> studentOfferings = offeringsRepository.findByRegisteredCoursesIn(studentRegCourses);
        return courseRepository.findByOfferingsIn(studentOfferings);

    }

    public List<Offerings> registeredOfferingList(int studentId) {
        Optional<Student> studentById = studentRepository.findById(studentId);
        if (!studentById.isPresent()) {
            throw new IllegalStateException("Student doesn't exist!");
        }
        Set<RegisteredCourses> studentRegCourses = studentById.get().getRegisteredCourses();
        List<Offerings> studentOfferings = offeringsRepository.findByRegisteredCoursesIn(studentRegCourses);
        return studentOfferings;
    }

    public boolean registerForCourse(Student student, Offerings offering) {
        Optional<Offerings> newOffering = offeringsRepository.findById(offering.getOfferingId());
        List<Course> studentCourses = registeredCourseList(student.getStudentId());
        if (studentCourses.contains(newOffering.get().getCourseId())) {
            throw new IllegalStateException("You are already registered for that course!");
        } else if (studentCourses.size() == 6) {
            throw new IllegalStateException("You are already registered for 6 courses!");
        }

        RegisteredCourses register = new RegisteredCourses(student, offering);
        System.out.print("Just checking\n\n");
        registeredCoursesRepository.save(register);
        return true;
    }

    public boolean deregisterFromCourse(int studentId, int offeringId) {

        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Offerings> offering = offeringsRepository.findById(offeringId);
        if (!student.isPresent()) {
            throw new IllegalStateException("Student doesn't exist!");
        }

        Optional<RegisteredCourses> registeredCourse = registeredCoursesRepository
                .findBystudentIdAndofferingId(student.get(), offering.get());
        if (registeredCourse.get() == null) {
            throw new IllegalStateException("Registered course doesn't exist!");
        }

        registeredCoursesRepository.delete(registeredCourse.get());
        return true;
    }

    public void checkout(Student studentId) {
        Optional<Student> studentById = studentRepository.findById(studentId.getStudentId());
        if (!studentById.isPresent()) {
            throw new IllegalStateException("Student doesn't exist!");
        }
        Set<RegisteredCourses> studentRegCourses = studentById.get().getRegisteredCourses();
        List<Offerings> studentOfferings = offeringsRepository.findByRegisteredCoursesIn(studentRegCourses);

        for (int i = 0; i < studentOfferings.size(); i++) {
            Set<RegisteredCourses> studentsRegistered = studentOfferings.get(i).getRegisteredCourses();

            if (studentsRegistered.size() < 8) {
                throw new IllegalAccessError(
                        "You are checking out. Please note that there are not enough (8) student registered in the "
                                + studentOfferings.get(i).getCourseId().getCourseID() + " offering yet.");
            }

        }

    }
}
