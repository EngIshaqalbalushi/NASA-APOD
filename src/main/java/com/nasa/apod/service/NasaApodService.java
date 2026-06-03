package com.nasa.apod.service;

import com.nasa.apod.model.ApodResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.*;

@Service
public class NasaApodService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;

    private final Map<String, ApodResponse> cache = new LinkedHashMap<>(256, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, ApodResponse> eldest) {
            return size() > 200;
        }
    };

    public NasaApodService(RestTemplate restTemplate,
                           @Value("${nasa.api.key}") String apiKey,
                           @Value("${nasa.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public ApodResponse getToday() {
        return getByDate(LocalDate.now().toString());
    }

    public ApodResponse getByDate(String date) {
        String cacheKey = "date:" + date;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("api_key", apiKey)
                .queryParam("date", date)
                .queryParam("thumbs", true)
                .build().toUriString();
        ApodResponse response = restTemplate.getForObject(url, ApodResponse.class);
        if (response != null) cache.put(cacheKey, response);
        return response;
    }

    public List<ApodResponse> getRange(String startDate, String endDate) {
        String cacheKey = "range:" + startDate + "|" + endDate;
        if (cache.containsKey(cacheKey)) {
            return Collections.singletonList(cache.get(cacheKey));
        }
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("api_key", apiKey)
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate)
                .queryParam("thumbs", true)
                .build().toUriString();
        ApodResponse[] arr = restTemplate.getForObject(url, ApodResponse[].class);
        List<ApodResponse> list = arr != null ? Arrays.asList(arr) : List.of();
        if (!list.isEmpty()) cache.put(cacheKey, list.get(0));
        return list;
    }

    public List<ApodResponse> getRandom(int count) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("api_key", apiKey)
                .queryParam("count", Math.min(count, 100))
                .queryParam("thumbs", true)
                .build().toUriString();
        ApodResponse[] arr = restTemplate.getForObject(url, ApodResponse[].class);
        return arr != null ? Arrays.asList(arr) : List.of();
    }

    @Scheduled(fixedRate = 3600000)
    public void prewarmToday() {
        try {
            getToday();
        } catch (Exception ignored) {}
    }
}
