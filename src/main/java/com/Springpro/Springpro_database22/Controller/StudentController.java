package com.Springpro.Springpro_database22.Controller;

import com.Springpro.Springpro_database22.Entity.Student;
import com.Springpro.Springpro_database22.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/addStudent")
    public void postDetails(@RequestBody Student student){
        System.out.println(student.getName());
        studentService.saveDetails(student);
//        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
//        return  studentService.saveDetails(student);
    }
    @GetMapping("/getStudent")
    public List<Student> getStudents(){
        return studentService.fetchAll();
    }
    @GetMapping("/getStudentwithname")
    public List<Student> getStudentswithname(@RequestBody Student student){
        System.out.println(student.getName());
        return studentService.fetchstudentswithname(student.getName());
    }
    @PostMapping("/addStudent2/{mark}/{name}")
    public List<Student> postDetails2(@PathVariable("mark") Integer mark, @PathVariable("name") String name){
        System.out.println(mark);
        System.out.println(name);
       return studentService.newstudent(mark,name);

    }
    @PostMapping("/addStudent3/{mark}/{name}")
    public void postDetails3(@PathVariable("mark") Integer mark, @PathVariable("name") String name){
        System.out.println(mark);
        System.out.println(name);
        studentService.saveDetails2(mark,name);

    }
}
