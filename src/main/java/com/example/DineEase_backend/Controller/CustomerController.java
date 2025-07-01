package com.example.DineEase_backend.Controller;

import com.example.DineEase_backend.Entity.Customer;
import com.example.DineEase_backend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return ResponseEntity.ok("Customer saved");
    }
    
}
