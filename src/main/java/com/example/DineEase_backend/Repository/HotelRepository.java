package com.example.DineEase_backend.Repository;

import com.example.DineEase_backend.Entity.Hotel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, ObjectId> {
}
