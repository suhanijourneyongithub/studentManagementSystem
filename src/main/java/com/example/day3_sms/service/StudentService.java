package com.example.day3_sms.service;

import com.example.day3_sms.dto.StudentRequestDto;
import com.example.day3_sms.dto.StudentResponseDto;
import com.example.day3_sms.exception.StudentNotFoundException;
import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final StudentRepo repository;

    public StudentService(StudentRepo repository) {
        this.repository = repository;
    }

    //CRUD

    //Create
     /*public StudentModel addStudent(StudentModel student){
       return repository.save(student);
    }*/
    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    /*
    why two objects for addStudent
    first one is for database
    and second one is for client / responseDto
    */

    //Read
    /*public List<StudentModel> getStudents(){
        return repository.findAll();
    }*/
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }
    /*
    hmne findAll ke alawa .stream() and .map() kyu use kra
    kyuki
    hmara function list return kar skti h studentResponseDto type ki
    but
    findAll return krta hai List StudentModel type ki
    to hum har ek element ko StudentResponseDto me convert krenge
     */

    //Update
    public StudentResponseDto updateStudent(String id, StudentRequestDto dto){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("No Student Found"));
        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());

        StudentModel saved = repository.save(existingStudent);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    //Delete
    public void deleteStudent(String id){
        if(!repository.existsById(id)){
            throw new StudentNotFoundException("No Student Found");
        }
        repository.deleteById(id);
    }

    public StudentResponseDto patchStudent(String id, Map<String, Object> updates) {
        StudentModel student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (updates.containsKey("name")) {
            student.setName((String) updates.get("name"));
        }

        if (updates.containsKey("age")) {
            student.setAge((Integer) updates.get("age"));
        }

        if (updates.containsKey("email")) {
            student.setEmail((String) updates.get("email"));
        }

        StudentModel updated = repository.save(student);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }
}