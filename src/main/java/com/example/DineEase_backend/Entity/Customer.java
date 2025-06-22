package com.example.DineEase_backend.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {
    @Id
    private ObjectId id;

    private String name;
    private String email;
    private String fullname;
}
