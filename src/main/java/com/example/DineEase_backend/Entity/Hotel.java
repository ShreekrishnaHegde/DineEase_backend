package com.example.DineEase_backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "owner")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @Id
    private ObjectId mongoId;

    private String supaId;
    private String email;
    private String fullname;
    private String role;
    private Menu menu=new Menu();
}
