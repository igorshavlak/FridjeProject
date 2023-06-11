package com.example.fridge.Entity;


import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    protected int id;
    protected LocalDateTime expirationDate;
    protected byte[] image;
    protected String productName;

    protected String type;

    protected Product(int id, LocalDateTime expirationDate, byte[] image, String productName){
        this.id = id;
        this.expirationDate = expirationDate;
        this.image = image;
        this.productName = productName;
    }
    protected Product(){

    }
    public static Product getInstance(Product product, String type){
        return switch (type) {
            case "Vegetable" ->
                    new Vegetable(product.getId(), product.getExpirationDate(), product.getImage(), product.getProductName());
            case "Fruit" ->
                    new Fruit(product.getId(), product.getExpirationDate(), product.getImage(), product.getProductName());
            case "MeatProduct" ->
                    new MeatProduct(product.getId(), product.getExpirationDate(), product.getImage(), product.getProductName());
            default -> throw new IllegalArgumentException("invalid data");
        };
    }
    public static Product getInstance(int id,String name, LocalDateTime date, byte[] photo, String type)
    {
        return switch (type) {
            case "Vegetable" ->
                    new Vegetable(id,date,photo,name);
            case "Fruit" ->
                    new Fruit(id,date,photo,name);
            case "MeatProduct" ->
                    new MeatProduct(id,date,photo,name);
            default -> throw new IllegalArgumentException("invalid data");
        };
    }

    public String getType(){
        return null;
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
}
