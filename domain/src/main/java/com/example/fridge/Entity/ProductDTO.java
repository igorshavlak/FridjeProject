package com.example.fridge.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ProductDTO {

    public String expirationDate;
    public String productName;

    public String type;
}
