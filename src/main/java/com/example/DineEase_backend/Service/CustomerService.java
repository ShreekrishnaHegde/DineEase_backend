package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Customer;
import com.example.DineEase_backend.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
