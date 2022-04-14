package com.example.schedulertest.weather.common;

import lombok.Getter;

@Getter
public enum MidLandRegion {
    GYEONGGI_DO("11B00000", "서울, 인천, 경기도", WeatherForecastType.MID_LAND),
    GANGWON_DO_YEONGSEO("11D10000", "강원도 영서", WeatherForecastType.MID_LAND),
    GANGWON_DO_YEONGDONG("11D20000", "강원도 영동", WeatherForecastType.MID_LAND),
    CHUNGCHEONGNAM_DO("11C20000", "대전, 세종, 충청남도", WeatherForecastType.MID_LAND),
    CHUNGCHEONGBUK_DO("11C10000", "충청북도", WeatherForecastType.MID_LAND);

    private final String code; //예보구역코드
    private final String name; //예보구역명
    private final WeatherForecastType type;

    MidLandRegion(String code, String name, WeatherForecastType type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }
}
