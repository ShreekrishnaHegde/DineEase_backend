package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Order;
import com.example.DineEase_backend.Repository.OrderRepository;
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
    public List<Order> getOrdersByHotelEmail(String email){
        return orderRepository.findByHotelId(email);
    }
}
