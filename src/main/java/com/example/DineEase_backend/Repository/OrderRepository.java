package com.example.DineEase_backend.Repository;

import com.example.DineEase_backend.Entity.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, ObjectId> {
    List<Order> findByHotelUsername(String hotelUsername);
}
