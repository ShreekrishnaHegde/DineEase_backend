package com.example.DineEase_backend.Entity;

import lombok.Data;

@Data
public class OrderItem {
    private String itemId;
    private String itemName;
    private int itemPrice;
    private int quantity;
}
