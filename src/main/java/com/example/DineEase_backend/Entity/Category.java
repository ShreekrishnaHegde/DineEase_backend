package com.example.DineEase_backend.Entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Category {
    private String categoryId= UUID.randomUUID().toString();
    private String categoryName;
    private List<Item> items=new ArrayList<>();

}
