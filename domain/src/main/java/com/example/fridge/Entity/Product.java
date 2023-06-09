package com.example.fridge.Entity;

import java.util.Date;

public class Product {
    private int id;
    private ICategory category;
    private Date expirationDate;
    private String productName;

    public Date getExpirationDate() {
        return expirationDate;
    }
    public String getProductName() {
        return productName;
    }
    public String getCategory() {
        return category.getCategory();
    }
}
