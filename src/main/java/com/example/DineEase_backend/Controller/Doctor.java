package com.example.DineEase_backend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Doctor {

    @GetMapping("/health-check")
    public Map<String,String> function(){
        return Map.of("meessage","Hello World Good Evening");
    }
}
