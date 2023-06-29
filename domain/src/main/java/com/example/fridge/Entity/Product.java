package com.example.fridge.Entity;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class Product {
    protected int id;
    protected LocalDateTime expirationDate;
    protected byte[] image;
    protected String productName;

    protected String type;
    protected boolean expiredStatus;
    protected boolean getWarn;
    protected Duration reminderPeriod;

    protected Product(int id, LocalDateTime expirationDate, Duration reminderPeriod, boolean expiredStatus,boolean getWarn, byte[] image, String productName){
        this.id = id;
        this.expirationDate = expirationDate;
        this.image = image;
        this.productName = productName;
        this.expiredStatus = expiredStatus;
        this.reminderPeriod = reminderPeriod;
        this.getWarn = getWarn;
    }
    protected Product(){

    }
    public static Product getInstance(int id,String name, LocalDateTime date, Duration reminderPeriod,boolean expiredStatus,boolean getWarn, byte[] photo, String type)
    {
        return switch (type) {
            case "Vegetable" ->
                    new Vegetable(id,date,reminderPeriod,expiredStatus,getWarn,photo,name);
            case "Fruit" ->
                    new Fruit(id,date,reminderPeriod,expiredStatus,getWarn,photo,name);
            case "MeatProduct" ->
                    new MeatProduct(id,date,reminderPeriod,expiredStatus,getWarn,photo,name);
            default -> throw new IllegalArgumentException("invalid data");
        };
    }

    public String getType(){
        return type;
    }
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
    public String getProductName() {
        return productName;
    }
    public byte[] getImage() {
        return image;
    }
    public int getId() {
        return id;
    }
    public boolean isGetWarn(){
        return getWarn;
    }
    public void setExpiredStatus(boolean expiredStatus) {
        this.expiredStatus = expiredStatus;
    }
    public boolean isExpiredStatus() {
        return expiredStatus;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
    public abstract String printExpirationWarning();
    public abstract String printWarningMessage();
    public Duration getReminderPeriod() {
        return reminderPeriod;
    }
    public void setReminderPeriod(Duration reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
    }
}
