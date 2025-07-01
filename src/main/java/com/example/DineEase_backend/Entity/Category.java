package com.example.DineEase_backend.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {
    private String categoryId= UUID.randomUUID().toString();
    private String categroyName;
    private List<Item> items=new ArrayList<>();

}
