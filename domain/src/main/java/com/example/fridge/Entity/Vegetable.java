package com.example.fridge.Entity;

import java.util.Date;

public class Vegetable extends Product {

    public Vegetable(int id, Date expirationDate, byte[] image, String productName) {
        super(id, expirationDate, image, productName);
        type = "Vegetable";
    }
    @Override
    public String getType(){
        return "Vegetable";
    }
}