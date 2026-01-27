package com.example.day3_sms.service;

import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    //Update Name
    public StudentModel updateStudent(String id, StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student Found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);
    }
    //Delete
    public void deleteStudent(String id){
        if(!repository.existsById(id)){
            throw new RuntimeException("No Student Found");
        }
        repository.deleteById(id);
    }

}