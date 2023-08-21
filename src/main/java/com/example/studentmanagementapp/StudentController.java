package com.example.studentmanagementapp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    Map<Integer,Student> db = new HashMap<>();
    @GetMapping("/get") // API 1
    public Student getStudent( @RequestParam("q") int regNo){  // q is used in url to represent regNo
        return db.get(regNo);
    }
@PostMapping("/add")
    public String addStudent( @RequestBody Student student ){ // adding student object * parameter passing is Student object
        db.put(student.getRegNo(),student);
        return "Student has been added successfully";
    }

    @GetMapping("/getMapByPath/{id}")
    public Student getStudentUsingPath(@PathVariable("id") int regNo){
        return db.get(regNo);
    }

    // using both @RequestParam() and @PathVariable()
    @PutMapping("/update-age/{id}")
    public Student updateAge(@PathVariable("id") int regNo , @RequestParam("age") int newAge){
        db.get(regNo).setAge(newAge);
        return db.get(regNo);
    }

    //delete student using --> request Param, and path variable
@DeleteMapping("/delete1")
    public String deleteOperation1(@RequestParam("regNo") int regNo){
        db.remove(regNo);
        return "SuccessFull run deleteOperation1";

}@DeleteMapping("/delete2/{id}")
    public String deleteOperation2(@PathVariable("id") int regNo){
        db.remove(regNo);
        return "SuccessFull run deleteOperation2";
}
    // change course of student --> using both as req

    @PutMapping("/updateCourse/{id}") // path variable and request param
    public Student updataCourse1( @PathVariable ("id") int regNo , @RequestParam("course") String course){
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }
    @PutMapping("/updateCourse/{id}/{course}") // path variable and path variable
    public Student updataCourse2(@PathVariable("id") int regNo ,@PathVariable("course") String course){
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }
    @PutMapping("/updateCourse") // request param and request param
    public Student updataCourse3(@RequestParam("id") int regNo ,@RequestParam("course") String course){
        db.get(regNo).setCourse(course);
        return db.get(regNo);
    }

    // change course and age  take entire student object  as parameter
    @PutMapping("/update-age-course/{id}")
public Student updateCourseAndAge(@PathVariable("id") int regNo, @RequestBody Student student){
        db.get(regNo).setCourse(student.getCourse());
        db.get(regNo).setAge(student.getAge());
        return db.get(regNo);
}
    //
}
