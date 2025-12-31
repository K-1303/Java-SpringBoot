package com.example.main;

import com.example.main.impl.EmailNotificationService;
import com.example.main.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

//    final NotificationService notificationService;
//
//    public MainApplication(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }

    @Autowired
    Map<String, NotificationService> notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        notificationService.send("Hello");

        for (var notificationService: notificationServiceMap.entrySet()) {
            System.out.println(notificationService.getKey());
            notificationService.getValue().send("Hello");
        }
    }
}
