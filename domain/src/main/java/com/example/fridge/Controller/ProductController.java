package com.example.fridge.Controller;

import com.example.fridge.Entity.*;
import com.example.fridge.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestPart("image") MultipartFile photo, @RequestPart("product") ProductDTO product,
                                             @RequestPart("productType") String type) throws IOException {
        boolean status;
        LocalDateTime date = LocalDateTime.parse(product.expirationDate,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        status = date.isBefore(LocalDateTime.now());
        productRepository.addProduct(Product.getInstance(0, product.productName, date, Duration.ofHours(product.reminderPeriod), status,false, photo.getBytes(), type));
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

    @Scheduled(fixedRate = 1000)
    public void checkExpiryStatus() {
        LocalDateTime currentDate = LocalDateTime.now();

        for (Product product : productRepository.getProducts()) {
            Duration timeLeft = Duration.between(currentDate,product.getExpirationDate());
            if (timeLeft.compareTo(product.getReminderPeriod()) <= 0 && (!product.isGetWarn())) {
                productRepository.updateWarnStatus(product.getId());
                simpMessagingTemplate.convertAndSend("/topic/messages",product.printWarningMessage());
            }
            if (product.getExpirationDate().isBefore(currentDate) && (!product.isExpiredStatus())) {
                    productRepository.updateStatus(product.getId());
                    System.out.println(product.getProductName() + " - expired ");
                    simpMessagingTemplate.convertAndSend("/topic/messages",product.printExpirationWarning());

            }
        }
    }
    @GetMapping("/expiredProducts")
    public List<Product> getExpiredProducts() {
        List<Product> expiredProducts = new ArrayList<>();
        LocalDateTime currentDate = LocalDateTime.now();
        for (Product product : productRepository.getProducts()) {
            if (product.getExpirationDate().isBefore(currentDate)) {
                expiredProducts.add(product);
            }
        }
        return expiredProducts;
    }
}
