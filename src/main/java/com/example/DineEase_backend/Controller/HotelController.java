package com.example.DineEase_backend.Controller;


import com.example.DineEase_backend.Entity.Category;
import com.example.DineEase_backend.Entity.Hotel;
import com.example.DineEase_backend.Entity.Item;
import com.example.DineEase_backend.Entity.Menu;
import com.example.DineEase_backend.Service.HotelService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    //To get all menu items
    @GetMapping("/{username}/menu/items")
    public ResponseEntity<List<Category>> getMenu(@PathVariable String username){
        ObjectId hotelId=hotelService.findIdByEmail(username);
        Menu menu=hotelService.getMenu(hotelId);
        return  ResponseEntity.ok(menu.getCategories());
    }
    //To add a category
    @PostMapping("/{username}/menu/category")
    ResponseEntity<?> addCategory(@PathVariable String username, @RequestBody Category category){
        ObjectId hotelId=hotelService.findIdByEmail(username);
        hotelService.addCategory(hotelId,category);
        return ResponseEntity.ok("OK");
    }
    //To delete a category
    @DeleteMapping("/{username}/menu/category/{categoryId}")
    ResponseEntity<?> deleteCategory(@PathVariable String username, @PathVariable String categoryId){
        ObjectId hotelId = hotelService.findIdByEmail(username);
        hotelService.deleteCategory(hotelId,categoryId);
        return ResponseEntity.ok("Deleted Category");
    }

    //To add an item
    @PostMapping("/{username}/menu/category/{categoryId}/item")
    ResponseEntity<?> addItem(@PathVariable String username,@PathVariable String categoryId,@RequestBody List<Item> items){
        ObjectId hotelId=hotelService.findIdByEmail(username);
        hotelService.addItems(hotelId,categoryId,items);
        return ResponseEntity.status(HttpStatus.CREATED).body("added Item");
    }
    //To delete an item
    @DeleteMapping("/{username}/menu/category/{categoryId}/item/{itemId}")
    ResponseEntity<?> deleteItem(@PathVariable String username,@PathVariable String categoryId,@PathVariable String itemId){
        ObjectId hotelId=hotelService.findIdByEmail(username);
        hotelService.deleteItem(hotelId,categoryId,itemId);
        return ResponseEntity.ok("Deleted an item");
    }


}
