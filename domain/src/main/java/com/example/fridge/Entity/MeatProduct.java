package com.example.fridge.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MeatProduct extends Product{

    public MeatProduct(int id, LocalDate expirationDate, boolean expiredStatus, byte[] image, String productName) {
        super(id,expirationDate,expiredStatus, image, productName);
        type = "MeatProduct";
    }
    @Override
    public String getType(){
        return "MeatProduct";
    }
}
