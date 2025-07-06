package com.example.DineEase_backend.Controller;

import com.example.DineEase_backend.Entity.Order;
import com.example.DineEase_backend.Service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResponseEntity.ok(HttpEntity.EMPTY);

    }
    @GetMapping("/hotel/{email}")
    public ResponseEntity<List<Order>> getOrdersByHotelEmail(@PathVariable String email) {
        List<Order> orders=orderService.getOrdersByHotelUsername(email);
        return ResponseEntity.ok(orders);
    }
    @GetMapping("customer/{username}")
    public ResponseEntity<List<Order>> getOrderByCustomer(@PathVariable String username){
        List<Order> orders=orderService.getOrdersByCustomerUsername(username);
        return ResponseEntity.ok(orders);
    }

}
