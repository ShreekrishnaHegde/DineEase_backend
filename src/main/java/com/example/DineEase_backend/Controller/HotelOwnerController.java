package com.example.DineEase_backend.Controller;


import com.example.DineEase_backend.Entity.HotelOwner;
import com.example.DineEase_backend.Service.HotelOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/hotel-owner")
public class HotelOwnerController {

    @Autowired
    private HotelOwnerService hotelOwnerService;

    @PostMapping
    ResponseEntity<?> saveHotelOwner(@RequestBody HotelOwner hotelOwner){
        hotelOwnerService.saveHotelOwner(hotelOwner);
        return ResponseEntity.ok("OK");
    }
}
