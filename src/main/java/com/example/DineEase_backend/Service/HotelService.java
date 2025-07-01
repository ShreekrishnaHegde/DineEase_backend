package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Category;
import com.example.DineEase_backend.Entity.Hotel;
import com.example.DineEase_backend.Entity.Item;
import com.example.DineEase_backend.Repository.HotelRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public void saveHotelOwner(Hotel hotel){
        hotelRepository.save(hotel);
    }
    public Hotel addCategory(ObjectId hotelId, Category category){
        Hotel hotel= hotelRepository.findById(hotelId).orElseThrow();
        hotel.getMenu().getCategories().add(category);
        return hotelRepository.save(hotel);
    }
    public Hotel addItem(ObjectId hotelId, String categoryId, Item item){
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow();
        Category category=hotel.getMenu().getCategories().stream()
                .filter(c -> c.getCategoryId().equals(categoryId)).findFirst().orElseThrow();
        category.getItems().add(item);
        return hotelRepository.save(hotel);
    }

}
