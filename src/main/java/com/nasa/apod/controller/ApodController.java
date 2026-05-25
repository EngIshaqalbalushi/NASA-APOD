package com.nasa.apod.controller;

import com.nasa.apod.model.ApodResponse;
import com.nasa.apod.service.NasaApodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apod")
public class ApodController {

    private final NasaApodService nasaApodService;

    public ApodController(NasaApodService nasaApodService) {
        this.nasaApodService = nasaApodService;
    }

    @GetMapping("/today")
    public ResponseEntity<ApodResponse> getToday() {
        return ResponseEntity.ok(nasaApodService.getToday());
    }

    @GetMapping
    public ResponseEntity<ApodResponse> getByDate(@RequestParam("date") String date) {
        return ResponseEntity.ok(nasaApodService.getByDate(date));
    }

    @GetMapping("/range")
    public ResponseEntity<List<ApodResponse>> getRange(
            @RequestParam("start_date") String startDate,
            @RequestParam(value = "end_date", required = false) String endDate) {
        return ResponseEntity.ok(nasaApodService.getRange(startDate, endDate));
    }

    @GetMapping("/random")
    public ResponseEntity<List<ApodResponse>> getRandom(
            @RequestParam(value = "count", defaultValue = "12") int count) {
        return ResponseEntity.ok(nasaApodService.getRandom(count));
    }
}
