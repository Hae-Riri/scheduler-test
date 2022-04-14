package com.example.schedulertest.weather;

import com.example.schedulertest.weather.service.LandWeatherService;
import com.example.schedulertest.weather.service.MidLandWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TourWeatherScheduler {
    private final LandWeatherService landWeatherService;
    private final MidLandWeatherService midLandWeatherService;

    @Scheduled(fixedRate = 2000)
    public void cacheLandWeather() {
        log.info("### 육상 예보 조회 시작");
        landWeatherService.cacheLandWeather();
    }

//    @Scheduled(fixedRate = 2000)
//    public void cacheMidLandWeather() {
//        log.info("### 중기육상예보 조회 시작");
//        midLandWeatherService.cacheMidLandWeather();
//    }

    public TourWeatherScheduler(LandWeatherService landWeatherService, MidLandWeatherService midLandWeatherService) {
        this.landWeatherService = landWeatherService;
        this.midLandWeatherService = midLandWeatherService;
    }
}
