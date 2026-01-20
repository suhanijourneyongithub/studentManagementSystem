package com.example.day3_sms.service;

import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepo repository;

    public StudentService(StudentRepo repository) {
        this.repository = repository;
    }

    //CRUD

    //Create
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
    //Read
    //Update
    //Delete
}