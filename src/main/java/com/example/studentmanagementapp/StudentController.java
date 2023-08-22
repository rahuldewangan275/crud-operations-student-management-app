package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
StudentService studentService;
    @GetMapping("/get") // API 1
    public Student getStudent( @RequestParam("q") int regNo){  // q is used in url to represent regNo
        return studentService.getStudent(regNo);
    }
@PostMapping("/add")
    public String addStudent( @RequestBody Student student ){ // adding student object * parameter passing is Student object
        return studentService.addStudent(student);
    }

    @GetMapping("/getMapByPath/{id}")
    public Student getStudentUsingPath(@PathVariable("id") int regNo){
        return studentService.getStudentUsingPath(regNo);
    }

    // using both @RequestParam() and @PathVariable()
    @PutMapping("/update-age/{id}")
    public Student updateAge(@PathVariable("id") int regNo , @RequestParam("age") int newAge){
     return studentService.updateAge(regNo , newAge);
    }

    //delete student using --> request Param, and path variable
@DeleteMapping("/delete1")
    public String deleteOperation1(@RequestParam("regNo") int regNo){
    return studentService.deleteOperation1(regNo);

}@DeleteMapping("/delete2/{id}")
    public String deleteOperation2(@PathVariable("id") int regNo){
return studentService.deleteOperation2(regNo);
}
    // change course of student --> using both as req

    @PutMapping("/updateCourse/{id}") // path variable and request param
    public Student updataCourse1( @PathVariable ("id") int regNo , @RequestParam("course") String course){
return studentService.updataCourse1(regNo,course);
    }

    @PutMapping("/updateCourse/{id}/{course}") // path variable and path variable
    public Student updataCourse2(@PathVariable("id") int regNo ,@PathVariable("course") String course){
return studentService.updataCourse2(regNo,course);
    }

    @PutMapping("/updateCourse") // request param and request param
    public Student updataCourse3(@RequestParam("id") int regNo ,@RequestParam("course") String course){
return studentService.updataCourse3(regNo,course);
    }

    // change course and age  take entire student object  as parameter
    @PutMapping("/update-age-course/{id}")
public Student updateCourseAndAge(@PathVariable("id") int regNo, @RequestBody Student student){
return studentService.updateCourseAndAge(regNo,student);
}
    //
}
