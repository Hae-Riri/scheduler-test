package com.example.schedulertest.weather.common;

public enum WeatherForecastType {
    LAND("0", "육상예보"),
    MID_LAND("1", "중기육상예보");

    private final String code;
    private final String description;

    WeatherForecastType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
