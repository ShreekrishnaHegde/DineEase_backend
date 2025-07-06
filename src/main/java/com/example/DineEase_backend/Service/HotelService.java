package com.example.DineEase_backend.Service;

import com.example.DineEase_backend.Entity.Category;
import com.example.DineEase_backend.Entity.Hotel;
import com.example.DineEase_backend.Entity.Item;
import com.example.DineEase_backend.Entity.Menu;
import com.example.DineEase_backend.Repository.HotelRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public void saveHotelOwner(Hotel hotel){
        hotelRepository.save(hotel);
    }
    //To find the hotel id via email
    public ObjectId findIdByEmail(String email){
        return hotelRepository.findByEmail(email)
                .map(Hotel::getMongoId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with email: " + email));
    }
    //To retrieve the menu items
    public Menu getMenu(ObjectId hotelId){
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow();
        return  hotel.getMenu();
    }
    //To add a category
    public void addCategory(ObjectId hotelId, Category category){
        Hotel hotel= hotelRepository.findById(hotelId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel Not Found"));
        hotel.getMenu().getCategories().add(category);
        hotelRepository.save(hotel);
    }
    //To delete a category
    public void deleteCategory(ObjectId hotelId, String categoryId){
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()
                 ->new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel Not Found"));
        hotel.getMenu().getCategories().removeIf(cat -> cat.getCategoryId().equals(categoryId));
        hotelRepository.save(hotel);
    }
    //To add items into a category
    public void addItems(ObjectId hotelId, String categoryId, List<Item> items){
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel Not Found"));
        Category category=hotel.getMenu().getCategories().stream()
                .filter(c -> c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Not Found"));
        category.getItems().addAll(items);
        hotelRepository.save(hotel);
    }
    //To delete an item
    public void deleteItem(ObjectId hotelId, String categoryId, String itemId){
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel Not found"));
        Category category=hotel.getMenu().getCategories().stream()
                .filter(cat -> cat.getCategoryId().equals(categoryId)).findFirst().orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Not Found"));
        category.getItems().removeIf(item -> item.getItemId().equals(itemId));
        hotelRepository.save(hotel);
    }
    //To retrieve userprofile
    public Hotel getHotel(ObjectId hotelId){
        Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel Not found"));
        return hotel;
    }
    //To update the profile of hotel user
    public Hotel updateByEmail(ObjectId hotelId, Hotel updatedHotel) {
        Hotel existing=hotelRepository.findById(hotelId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Hotel Not found"));
        existing.setHotelName(updatedHotel.getHotelName());
        existing.setFullname(updatedHotel.getFullname());
        existing.setAddress(updatedHotel.getAddress());
        return hotelRepository.save(existing);
    }

    //For real time searching of hotel
    public List<Hotel> searchHotels(String query){
        return hotelRepository.findByHotelNameContainingIgnoreCase(query);
    }
    public  String getHotelName(String hotelUserName){
        return hotelRepository.findByEmail(hotelUserName).map(Hotel::getHotelName).orElseThrow(()->
                new RuntimeException("Hotel Not Found"));
    }

}
