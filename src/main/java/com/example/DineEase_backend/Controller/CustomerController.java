package com.example.DineEase_backend.Controller;

import com.example.DineEase_backend.Entity.Customer;
import com.example.DineEase_backend.Service.CustomerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{username}/profile")
    public Customer getCustomerProfile(@PathVariable String username){
        ObjectId customerId=customerService.findByIdEmail(username);
        return customerService.getCustomer(customerId);
    }
    @PutMapping("{username}/profile")
    public Customer updateCustomerProfile(@PathVariable String username,@RequestBody Customer customer){
        ObjectId customerId=customerService.findByIdEmail(username);
        return customerService.updateByEmail(customerId,customer);
    }
}
