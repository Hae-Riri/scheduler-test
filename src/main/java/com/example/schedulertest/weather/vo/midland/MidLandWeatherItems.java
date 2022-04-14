package com.example.schedulertest.weather.vo.midland;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class MidLandWeatherItems {
    @JsonProperty("item")
    private List<MidLandWeatherItem> midLandWeatherItems;
}
