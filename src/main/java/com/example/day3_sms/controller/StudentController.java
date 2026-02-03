package com.example.day3_sms.controller;

import com.example.day3_sms.dto.StudentRequestDto;
import com.example.day3_sms.dto.StudentResponseDto;
import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //Create function's API
    @PostMapping("/addStudent")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }

    //Read function's API
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getAllStudents();
    }

    //UpdateByID
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@Valid @PathVariable String id,@Valid @RequestBody StudentRequestDto student){
        return service.updateStudent(id, student);
    }

    //DeleteByID
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}


/*
WORK FLOW
Controller -> service -> dto -> model
*/