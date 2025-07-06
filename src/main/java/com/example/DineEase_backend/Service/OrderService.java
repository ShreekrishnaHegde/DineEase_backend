package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Customer;
import com.example.DineEase_backend.Entity.Order;
import com.example.DineEase_backend.Repository.HotelRepository;
import com.example.DineEase_backend.Repository.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private HotelService hotelService;

    public void saveOrder(Order order){
        String hotelName= hotelService.getHotelName(order.getHotelUsername());
        order.setHotelName(hotelName);
        orderRepository.save(order);
    }
    public List<Order> getOrdersByHotelUsername(String email) {
        return orderRepository.findByHotelUsername(email);
    }


    public List<Order> getOrdersByCustomerUsername(String username) {
        return orderRepository.findByCustomerUsername(username);
    }
}
