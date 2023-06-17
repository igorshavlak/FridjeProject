package com.example.fridge.Controller;

import com.example.fridge.Entity.*;
import com.example.fridge.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestPart("image") MultipartFile photo, @RequestPart("product") ProductDTO product,
                                             @RequestPart("productType") String type) throws IOException {
        boolean status;
        LocalDate date = LocalDate.parse(product.expirationDate);
        status = date.isBefore(LocalDate.now());
        productRepository.addProduct(Product.getInstance(0, product.productName, date, status, photo.getBytes(), type));
        return ResponseEntity.ok("product was added");
    }

    @GetMapping("/getProduct")
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productRepository.deleteProduct(id);
        return ResponseEntity.ok("success");

    }

    @Scheduled(fixedRate = 36000)
    public void checkExpiryStatus() {
        LocalDate currentDate = LocalDate.now();

        for (Product product : productRepository.getProducts()) {
            if (product.getExpirationDate().isBefore(currentDate) && (!product.isExpiredStatus())){
                    product.setExpiredStatus(true);
                    System.out.println(product.getProductName() + " - expired ");
            }
        }
    }
    @GetMapping("/expiredProducts")
    public List<Product> getExpiredProducts() {
        List<Product> expiredProducts = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Product product : productRepository.getProducts()) {
            if (product.getExpirationDate().isBefore(currentDate)) {
                expiredProducts.add(product);
            }
        }
        return expiredProducts;
    }
}
