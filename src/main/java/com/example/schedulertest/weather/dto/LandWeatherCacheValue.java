package com.example.schedulertest.weather.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class LandWeatherCacheValue {
    private String announceTime; // 발표시간
    private List<LandWeatherCacheValueItem> cacheValueItems;

    @Builder
    public LandWeatherCacheValue(String announceTime, List<LandWeatherCacheValueItem> cacheValueItems) {
        this.announceTime = announceTime;
        this.cacheValueItems = cacheValueItems;
    }
}
