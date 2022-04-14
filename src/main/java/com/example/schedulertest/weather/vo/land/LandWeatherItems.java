package com.example.schedulertest.weather.vo.land;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class LandWeatherItems {
    @JsonProperty("item")
    private List<LandWeatherItem> landWeatherItems;
}
