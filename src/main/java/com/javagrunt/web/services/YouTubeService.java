package com.javagrunt.web.services;

import com.javagrunt.web.views.videos.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class YouTubeService {
    private final RestTemplate restTemplate;

    public YouTubeService(RestTemplateBuilder restTemplateBuilder, @Value("${apiBase}") String runnerServiceUri) {
        this.restTemplate = restTemplateBuilder.rootUri(runnerServiceUri).build();
    }

    public Video[] getAll() {
        return Objects.requireNonNull(restTemplate.getForObject("/api/youTubeVideos", Video[].class));
    }

    public Boolean isHealthy() {
        try {
            String response = restTemplate.getForObject("/actuator/health", String.class);
            if (response != null && response.contains("UP")) {
                return Boolean.TRUE;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Boolean.FALSE;
    }
}
