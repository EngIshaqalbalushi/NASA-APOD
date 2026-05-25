package com.nasa.apod.controller;

import com.nasa.apod.model.NewsletterSubscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class NewsletterController {

    private final Map<String, String> subscribers = new ConcurrentHashMap<>();

    @PostMapping("/newsletter")
    public ResponseEntity<Map<String, String>> subscribe(@RequestBody NewsletterSubscription sub) {
        if (sub.getEmail() == null || !sub.getEmail().contains("@")) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid email"));
        }
        subscribers.put(sub.getEmail(), sub.getEmail());
        return ResponseEntity.ok(Map.of("status", "subscribed", "email", sub.getEmail()));
    }
}
