package com.example.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PaymentService paymentService() {
        System.out.println("Creating Payment Object");
        return new PaymentService();
    }
}
