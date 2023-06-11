package com.example.fridge.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Fruit extends Product {



    public Fruit(int id, LocalDateTime expirationDate, byte[] image, String productName) {
        super(id, expirationDate, image, productName);
        type = "Fruit";
    }
    @Override
    public String getType(){
        return "Fruit";
    }
}
