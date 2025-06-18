package com.example.DineEase_backend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Doctor {

    @GetMapping("/health-check")
    public String function(){
        return "Hello World";
    }
}
