package com.example.fridge.Entity;

import java.util.Date;

public class MeatProduct extends Product{

    public MeatProduct(int id,Date expirationDate, byte[] image, String productName) {
        super(id,expirationDate, image, productName);
        type = "MeatProduct";
    }
    @Override
    public String getType(){
        return "MeatProduct";
    }
}
