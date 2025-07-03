package com.example.DineEase_backend.Repository;

import com.example.DineEase_backend.Entity.Category;
import com.example.DineEase_backend.Entity.Hotel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, ObjectId> {
    Optional<Hotel> findByEmail(String email);
}
