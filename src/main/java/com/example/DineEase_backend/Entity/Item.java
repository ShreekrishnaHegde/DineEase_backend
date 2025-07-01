package com.example.DineEase_backend.Entity;

import java.util.UUID;

public class Item {
    private String itemId= UUID.randomUUID().toString();
    private String itemName;
    private int itemPrice;
}
