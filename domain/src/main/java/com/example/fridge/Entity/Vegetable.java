package com.example.fridge.Entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Vegetable extends Product {

    public Vegetable(int id, LocalDateTime expirationDate, Duration reminderPeriod, boolean expiredStatus,boolean getWarn, byte[] image, String productName) {
        super(id, expirationDate, reminderPeriod, expiredStatus,getWarn, image, productName);
        type = "Vegetable";
    }
    @Override
    public String printExpirationWarning() {
        return "Vegetable: " + getProductName() + " was expired";
    }
    @Override
    public String printWarningMessage() {
        return "Vegetable:  " + getProductName() +
                " will expire in " + getReminderPeriod().toHours() + " hour";}
}