package com.example.fridge.Repository;

import com.example.fridge.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String INSERT_PRODUCTS = """
        INSERT INTO Products(productName,type,expirationDate,expiredStatus,photo) VALUES (?,?,?,?,?)
        """;
    private static final String FETCH_ALL_PRODUCTS = """
        SELECT * FROM Products
        """;
    private static final String DELETE_PRODUCT = """
        DELETE FROM Products WHERE Id = ?
        """;
    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProduct(Product product) {
        jdbcTemplate.update(INSERT_PRODUCTS, product.getProductName(), product.getType(), product.getExpirationDate(),product.isExpiredStatus(),product.getImage());
    }
    public List<Product> getProducts(){
        return jdbcTemplate.query(FETCH_ALL_PRODUCTS, (resultSet, rowNum) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("productname");
            LocalDateTime expiryDate = resultSet.getTimestamp("expirationdate").toLocalDateTime();
            boolean expiredStatus = resultSet.getBoolean("expiredStatus");
            String type = resultSet.getString("type");
            byte[] photo = resultSet.getBytes("photo");
            return Product.getInstance(id,name,expiryDate,expiredStatus,photo,type);
        });

    }
    public boolean deleteProduct(int id){
        return jdbcTemplate.update(DELETE_PRODUCT, id) > 0;
    }
}