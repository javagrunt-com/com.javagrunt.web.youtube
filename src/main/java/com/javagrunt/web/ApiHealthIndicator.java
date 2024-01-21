package com.javagrunt.web;

import com.javagrunt.web.services.YouTubeService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ApiHealthIndicator implements HealthIndicator {

    private final YouTubeService youTubeService;

    public ApiHealthIndicator(YouTubeService youTubeService){
        this.youTubeService = youTubeService;
    }

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        if(!youTubeService.isHealthy()){
            return 1;
        }
        return 0; // healthy
    }
}
