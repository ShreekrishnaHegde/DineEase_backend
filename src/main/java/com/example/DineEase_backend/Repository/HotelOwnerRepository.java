package com.example.DineEase_backend.Repository;

import com.example.DineEase_backend.Entity.HotelOwner;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelOwnerRepository extends MongoRepository<HotelOwner, ObjectId> {
}
