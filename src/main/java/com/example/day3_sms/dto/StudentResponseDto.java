package com.example.day3_sms.dto;

//record is an immutable object in which no changes occur at runtime
public record StudentResponseDto(
        String id,
        String name,
        int age,
        String email
) {

}
//{} ke jab likhte h jab hmko chaiye ki iske mid ka data mask hoke jaye frontend me

//tell us why we haven't write anything in it

//{} empty → “default behavior is enough”
//Add code → “I want custom behavior”
//Masking → “client should not see raw data”