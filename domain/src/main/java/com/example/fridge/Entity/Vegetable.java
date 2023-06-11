package com.example.fridge.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Vegetable extends Product {

    public Vegetable(int id, LocalDateTime expirationDate, byte[] image, String productName) {
        super(id, expirationDate, image, productName);
        type = "Vegetable";
    }
    @Override
    public String getType(){
        return "Vegetable";
    }
}