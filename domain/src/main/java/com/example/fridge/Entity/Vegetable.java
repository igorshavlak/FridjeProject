package com.example.fridge.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Vegetable extends Product {

    public Vegetable(int id, LocalDateTime expirationDate,  boolean expiredStatus,byte[] image, String productName) {
        super(id, expirationDate, expiredStatus, image, productName);
        type = "Vegetable";
    }
    @Override
    public String getType(){
        return "Vegetable";
    }
}