package com.nasa.apod.controller;

import com.nasa.apod.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        String reply = chatService.chat(message);
        return Map.of("reply", reply);
    }
}
