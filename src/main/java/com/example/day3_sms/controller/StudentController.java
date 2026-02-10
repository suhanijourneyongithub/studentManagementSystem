package com.example.day3_sms.controller;

import com.example.day3_sms.dto.StudentRequestDto;
import com.example.day3_sms.dto.StudentResponseDto;
import com.example.day3_sms.service.StudentService;
import com.example.day3_sms.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")

@RestController
public class StudentController {
    private final StudentService service;
    public final JwtUtil jwtUtil;

    public StudentController(StudentService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    private void checkToken(String authHeader){
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Invalid Token");
        }
        String token = authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }

    //Create function's API
    @PostMapping("/addStudent")
    public StudentResponseDto addStudent(
            @RequestHeader(value = "Authorization") String authHeader,
            @Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }

    //Read function's API
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(
            @RequestHeader(value = "Authorization", required = false) String authHeader){
        checkToken(authHeader);
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
    @PatchMapping("/patch/{id}")
    public StudentResponseDto patchStudent(@PathVariable String id,
                                           @RequestBody Map<String, Object> updates) {
        return service.patchStudent(id, updates);
    }
}

/*
WORK FLOW
Controller -> service -> dto -> model
*/