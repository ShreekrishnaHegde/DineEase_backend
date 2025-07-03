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
    @PostMapping("/{username}/menu/categories")
    ResponseEntity<?> addCategory(@PathVariable String username, @RequestBody Category category){
        ObjectId hotelId=hotelService.findIdByEmail(username);
        hotelService.addCategory(hotelId,category);
        return ResponseEntity.ok("OK");
    }
    @PostMapping("/{username}/menu/categories/{categoryId}/items")
    ResponseEntity<?> addItem(@PathVariable String username,@PathVariable String categoryId,@RequestBody Item item){
        ObjectId hotelId=hotelService.findIdByEmail(username);
        hotelService.addItem(hotelId,categoryId,item);
        return ResponseEntity.status(HttpStatus.CREATED).body("added Item");
    }
    @GetMapping("/{username}/menu/items")
    public ResponseEntity<List<Item>> getAllItems(@PathVariable String username){
        ObjectId hotelId=hotelService.findIdByEmail(username);
        List<Item> items=hotelService.getAllItems(hotelId);
        return ResponseEntity.ok(items);
    }

}
