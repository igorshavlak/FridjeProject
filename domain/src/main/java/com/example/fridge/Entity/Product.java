package com.example.fridge.Entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class Product {
    protected int id;
    protected LocalDate expirationDate;
    protected byte[] image;
    protected String productName;

    protected String type;
    protected boolean expiredStatus;

    protected Product(int id, LocalDate expirationDate, boolean expiredStatus, byte[] image, String productName){
        this.id = id;
        this.expirationDate = expirationDate;
        this.image = image;
        this.productName = productName;
        this.expiredStatus = expiredStatus;
    }
    protected Product(){

    }
    public static Product getInstance(int id,String name, LocalDate date,boolean expiredStatus, byte[] photo, String type)
    {
        return switch (type) {
            case "Vegetable" ->
                    new Vegetable(id,date,expiredStatus,photo,name);
            case "Fruit" ->
                    new Fruit(id,date,expiredStatus,photo,name);
            case "MeatProduct" ->
                    new MeatProduct(id,date,expiredStatus,photo,name);
            default -> throw new IllegalArgumentException("invalid data");
        };
    }

    public String getType(){
        return null;
    }

    public LocalDate getExpirationDate() {
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

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
