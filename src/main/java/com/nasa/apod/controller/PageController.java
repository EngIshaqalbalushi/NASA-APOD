package com.nasa.apod.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class PageController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> home() throws IOException {
        return html("nasa_apod_home/code.html");
    }

    @GetMapping(value = "/gallery", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> gallery() throws IOException {
        return html("nasa_apod_gallery_redesign/code.html");
    }

    @GetMapping(value = "/about", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> about() throws IOException {
        return html("nasa_apod_about/code.html");
    }

    @GetMapping(value = "/community", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> community() throws IOException {
        return html("nasa_apod_community/code.html");
    }

    @GetMapping(value = "/api-docs", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> apiDocs() throws IOException {
        return html("nasa_apod_api_developers/code.html");
    }

    private ResponseEntity<String> html(String path) throws IOException {
        String content = Files.readString(Path.of(path), StandardCharsets.UTF_8);
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(content);
    }
}
