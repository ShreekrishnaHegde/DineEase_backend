package com.example.DineEase_backend.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "owner")
public class HotelOwner {
    @Id
    private ObjectId Id;

    private String name;
    private String email;
    private String fullname;
}
