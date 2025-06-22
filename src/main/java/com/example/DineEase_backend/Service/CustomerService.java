package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Customer;
import com.example.DineEase_backend.Repository.CustomerReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerReposity customerReposity;

    public void saveCustomer(Customer customer){
        customerReposity.save(customer);
    }
}
