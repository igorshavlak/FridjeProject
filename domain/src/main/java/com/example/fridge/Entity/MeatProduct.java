package com.example.fridge.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class MeatProduct extends Product{

    public MeatProduct(int id, LocalDateTime expirationDate, byte[] image, String productName) {
        super(id,expirationDate, image, productName);
        type = "MeatProduct";
    }
    @Override
    public String getType(){
        return "MeatProduct";
    }
}
