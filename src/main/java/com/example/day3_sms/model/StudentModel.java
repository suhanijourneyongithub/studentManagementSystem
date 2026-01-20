package com.example.day3_sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentModel {
    @Id //to make id a primary key
    private String id;
    private String name;
    private int age;
    private String email;
}