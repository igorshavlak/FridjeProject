package com.example.fridge.Entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MeatProduct extends Product{

    public MeatProduct(int id, LocalDateTime expirationDate, Duration reminderPeriod, boolean expiredStatus,boolean getWarn, byte[] image, String productName) {
        super(id,expirationDate,reminderPeriod,expiredStatus,getWarn, image, productName);
        type = "MeatProduct";
    }

    @Override
    public String printExpirationWarning() {
        return "Meat product: " + getProductName() + " was expired";
    }

    @Override
    public String printWarningMessage() {return "Meat product:  " + getProductName() + " will expire in " + getReminderPeriod().toHours() + " hour";}
}
