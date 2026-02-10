package com.example.day3_sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
    @NotBlank(message = "Email is Required")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password is Required")
    @Size(min = 6, message = "Password must be of atleast 6 char")
    private String password;
}
