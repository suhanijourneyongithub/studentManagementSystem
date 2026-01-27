package com.example.day3_sms.controller;

import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //Create function's API
    @PostMapping("/addStudent")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }
    //Read function's API
    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }
}