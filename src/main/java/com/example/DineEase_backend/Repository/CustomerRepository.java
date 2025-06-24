package com.example.DineEase_backend.Repository;

import com.example.DineEase_backend.Entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
