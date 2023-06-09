package com.example.fridge.Repository;

import com.example.fridge.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String INSERT_PRODUCTS = """
        INSERT INTO Products(productName,categoryName,expirationDate) VALUES (?,?,?)
        """;
    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProduct(Product product) {
        jdbcTemplate.update(INSERT_PRODUCTS, product.getProductName(), product.getCategory(), product.getExpirationDate());
    }
}