package com.example.DineEase_backend.Controller;


import com.example.DineEase_backend.Entity.Category;
import com.example.DineEase_backend.Entity.Hotel;
import com.example.DineEase_backend.Entity.Item;
import com.example.DineEase_backend.Service.HotelService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    ResponseEntity<?> saveHotelOwner(@RequestBody Hotel hotel){
        hotelService.saveHotelOwner(hotel);
        return ResponseEntity.ok("OK");
    }
    @PostMapping("/{hotelId}/menu/categories")
    ResponseEntity<?> addCategory(@PathVariable ObjectId hotelId, @RequestBody Category category){
        hotelService.addCategory(hotelId,category);
        return ResponseEntity.ok("OK");
    }
    @PostMapping("/{hotelId}/menu/categories/{categoryId}/items")
    ResponseEntity<?> addItem(@PathVariable ObjectId hotelId,@PathVariable String categoryId,@RequestBody Item item){
        hotelService.addItem(hotelId,categoryId,item);
        return ResponseEntity.status(HttpStatus.CREATED).body("added Item");
    }
    @GetMapping("/{hotelId}/menu/items")
    public ResponseEntity<List<Item>> getAllItems(@PathVariable ObjectId hotelId){
        List<Item> items=hotelService.getAllItems(hotelId);
        return ResponseEntity.ok(items);
    }

}
