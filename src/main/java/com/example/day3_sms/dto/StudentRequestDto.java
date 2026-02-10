package com.example.day3_sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    @NotBlank(message = "Name can't be blank")
    private String name;

    @Min(value = 5, message = "Age can't be less than 5")
    @Max(value = 90, message = "Age can't be more than 90")
    private Integer age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email can't be blank")
    private String email;
}

//is working as a middleware
//why both model and DTO have getter and setter?
/*
because dto is for validation i.e. service can't directly save some random data to model (database)
we will first validate the data in dto then only send data to model else show error msg
 */

/*
why requestDto is java class and responseDto a record
because of
requestDto  - mutability
responseDto - immutability
 */