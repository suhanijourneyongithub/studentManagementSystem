package com.example.day3_sms.repository;

import com.example.day3_sms.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<StudentModel, String> { //StudentModel me primaryKey String hai therefore String likha h

}
