package com.example.DineEase_backend.Entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Item {
    private String itemId= UUID.randomUUID().toString();
    private String itemName;
    private int itemPrice;
}
