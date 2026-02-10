package com.example.day3_sms.controller;

import com.example.day3_sms.dto.LoginRequestDto;
import com.example.day3_sms.dto.RegisterRequestDto;
import com.example.day3_sms.dto.TokenResponseDto;
import com.example.day3_sms.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth") //a base URL is created
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service){
        this.service = service;
    }
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto dto){
        return service.login(dto);
    }
    @PostMapping("/register")
    public TokenResponseDto register(@RequestBody RegisterRequestDto dto){
        return service.register(dto);
    }
}
