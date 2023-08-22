package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public Student getStudent(int regNo) {
        return studentRepository.getStudent(regNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudentUsingPath(int regNo) {
       return studentRepository.getStudentUsingPath(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        return studentRepository.updateAge(regNo,newAge);
    }

    public String deleteOperation1(int regNo) {
        return studentRepository.deleteOperation1(regNo);
    }

    public String deleteOperation2(int regNo) {
        return studentRepository.deleteOperation2(regNo);
    }

    public Student updataCourse1(int regNo, String course) {
        return studentRepository.updataCourse1(regNo,course);
    }

    public Student updataCourse2(int regNo, String course) {
        return studentRepository.updataCourse2(regNo,course);
    }

    public Student updataCourse3(int regNo, String course) {
        return studentRepository.updataCourse3(regNo,course);
    }

    public Student updateCourseAndAge(int regNo, Student student) {
        return studentRepository.updateCourseAndAge(regNo,student);
    }
}
