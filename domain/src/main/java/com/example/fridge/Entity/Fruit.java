package com.example.fridge.Entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Fruit extends Product {

    public Fruit(int id, LocalDateTime expirationDate, Duration reminderPeriod, boolean expiredStatus,boolean getWarn, byte[] image, String productName) {
        super(id, expirationDate,reminderPeriod, expiredStatus, getWarn, image, productName);
        type = "Fruit";
    }
    @Override
    public String printExpirationWarning() {
        return "Fruit: " + getProductName() + " was expired";
    }

    @Override
    public String printWarningMessage() {return "Fruit:  " + getProductName() + " will expire in " + getReminderPeriod().toHours() + " hour";}
}
