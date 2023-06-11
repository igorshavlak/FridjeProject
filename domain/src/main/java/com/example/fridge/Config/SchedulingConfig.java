package com.example.fridge.Config;

import com.example.fridge.Controller.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Scheduled(fixedRate = 3600000)
    public void checkExpiryStatus() {

    }
}
