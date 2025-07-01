package com.example.DineEase_backend.Entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {
    private List<Category> categories=new ArrayList<>();

}
