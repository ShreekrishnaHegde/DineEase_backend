package com.example.DineEase_backend.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class Order {
    @Id
    private String id;
    private String hotelId;
    private String customerName;
    private List<OrderItem> items;
    private int totalAmount;
    private String status;
    private long timestamp = System.currentTimeMillis();
}
