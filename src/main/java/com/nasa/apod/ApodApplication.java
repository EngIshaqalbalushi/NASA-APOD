package com.nasa.apod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApodApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApodApplication.class, args);
    }
}
