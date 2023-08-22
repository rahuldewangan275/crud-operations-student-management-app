package com.example.studentmanagementapp;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent(int regNo) {
        return db.get(regNo);
    }

    public String addStudent(Student student) {
        db.put(student.getRegNo(),student);
        return "Student has been added successfully";
    }

    public Student getStudentUsingPath(int regNo) {
        return db.get(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        db.get(regNo).setAge(newAge);
        return db.get(regNo);
    }

    public String deleteOperation1(int regNo) {
        db.remove(regNo);
        return "SuccessFull run deleteOperation1";
    }

    public String deleteOperation2(int regNo) {
        db.remove(regNo);
        return "SuccessFull run deleteOperation2";
    }

    public Student updataCourse1(int regNo, String course) {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student updataCourse2(int regNo, String course) {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student updataCourse3(int regNo, String course) {
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    public Student updateCourseAndAge(int regNo, Student student) {
        db.get(regNo).setCourse(student.getCourse());
        db.get(regNo).setAge(student.getAge());
        return db.get(regNo);
    }
}
