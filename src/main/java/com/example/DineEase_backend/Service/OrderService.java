package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Customer;
import com.example.DineEase_backend.Entity.Order;
import com.example.DineEase_backend.Repository.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order){
        orderRepository.save(order);
    }
    public List<Order> getOrdersByHotelUsername(String email) {
        return orderRepository.findByHotelUsername(email);
    }


}
