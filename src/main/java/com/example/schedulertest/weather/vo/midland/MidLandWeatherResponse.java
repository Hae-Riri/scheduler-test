package com.example.schedulertest.weather.vo.midland;

import com.example.schedulertest.weather.vo.Header;
import lombok.Getter;

@Getter
public class MidLandWeatherResponse {
    private Header header;
    private MidLandWeatherBody body;
}
