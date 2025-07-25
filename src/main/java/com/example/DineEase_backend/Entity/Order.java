package com.example.DineEase_backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private String id;
    private String hotelUsername;
    private String hotelName;
    private String customerUsername;
    private List<OrderItem> items;
    private int totalAmount;
    private String status;
    private long timestamp = System.currentTimeMillis();
}
