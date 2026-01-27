package com.example.day3_sms.repository;

import com.example.day3_sms.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepo extends MongoRepository<StudentModel, String> {
    List<StudentModel> id(String id); //StudentModel me primaryKey String hai therefore String likha h

}
