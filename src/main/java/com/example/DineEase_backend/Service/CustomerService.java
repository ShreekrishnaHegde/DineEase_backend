package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Customer;
import com.example.DineEase_backend.Repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }
    //To retrieve customer profile
    public Customer getCustomer(ObjectId customerId){
        Customer customer=customerRepository.findById(customerId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));
        return customer;
    }
    public Customer updateByEmail(ObjectId customerId,Customer updatedCustomer){
        Customer existing=customerRepository.findById(customerId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));
        existing.setFullname(updatedCustomer.getFullname());
        return customerRepository.save(existing);
    }

}
