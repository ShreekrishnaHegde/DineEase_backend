package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.HotelOwner;
import com.example.DineEase_backend.Repository.HotelOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelOwnerService {
    @Autowired
    private HotelOwnerRepository hotelOwnerRepository;

    void saveHotelOwner(HotelOwner hotelOwner){
        hotelOwnerRepository.save(hotelOwner);
    }
}
