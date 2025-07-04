package com.example.DineEase_backend.Repository;

import com.example.DineEase_backend.Entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

}
