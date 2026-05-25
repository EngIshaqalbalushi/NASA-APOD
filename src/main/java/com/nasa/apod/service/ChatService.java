package com.nasa.apod.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String model;

    public ChatService(RestTemplate restTemplate,
                       @Value("${openrouter.api.key}") String apiKey,
                       @Value("${openrouter.model}") String model) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.model = model;
    }

    public String chat(String message) {
        String systemPrompt = "You are a helpful NASA space assistant called Cosmos Assistant. "
                + "Answer questions about astronomy, space, NASA's Astronomy Picture of the Day (APOD), "
                + "and help users explore the cosmos. Keep responses concise and informative.";

        Map<String, Object> body = Map.of(
                "model", model,
                "messages", List.of(
                        Map.of("role", "system", "content", systemPrompt),
                        Map.of("role", "user", "content", message)
                ),
                "stream", false
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("HTTP-Referer", "http://localhost:8080");
        headers.set("X-Title", "NASA APOD Explorer");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    "https://openrouter.ai/api/v1/chat/completions", request, Map.class);
            if (response.getBody() != null) {
                Object choicesObj = response.getBody().get("choices");
                if (choicesObj instanceof List) {
                    List<Map<String, Object>> choices = (List<Map<String, Object>>) choicesObj;
                    if (!choices.isEmpty()) {
                        Map<String, Object> choice = choices.get(0);
                        Map<String, Object> msg = (Map<String, Object>) choice.get("message");
                        if (msg != null && msg.get("content") != null) {
                            return msg.get("content").toString();
                        }
                    }
                }
                Object errorObj = response.getBody().get("error");
                if (errorObj != null) {
                    return "API error: " + errorObj.toString();
                }
            }
            return "Sorry, I couldn't process that request.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
