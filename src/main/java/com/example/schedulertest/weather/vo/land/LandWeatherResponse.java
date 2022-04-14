package com.example.schedulertest.weather.vo.land;

import com.example.schedulertest.weather.vo.Header;
import lombok.Getter;

@Getter
public class LandWeatherResponse {
    private Header header;
    private LandWeatherBody body;
}
