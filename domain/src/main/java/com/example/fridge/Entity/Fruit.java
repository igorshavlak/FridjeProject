package com.example.fridge.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Fruit extends Product {

    public Fruit(int id, LocalDateTime expirationDate, boolean expiredStatus, byte[] image, String productName) {
        super(id, expirationDate, expiredStatus, image, productName);
        type = "Fruit";
    }
    @Override
    public String printExpirationWarning() {
        return "Fruit: " + getProductName() + " was expired";
    }
}
