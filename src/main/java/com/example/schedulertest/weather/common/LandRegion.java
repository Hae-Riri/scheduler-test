package com.example.schedulertest.weather.common;

import lombok.Getter;

@Getter
public enum LandRegion {
    SEOUL("11B10101", "서울", "Seoul", "1", "0", WeatherForecastType.LAND),
    INCHEON("11B20201", "인천", "Incheon", "2", "0", WeatherForecastType.LAND),
    SUWON("11B20601", "수원", "Suwon", "31", "13", WeatherForecastType.LAND),
    SEONGNAM("11B20605", "성남", "Seongnam", "31", "12", WeatherForecastType.LAND),
    ANYANG("11B20602", "안양", "Anyang", "31", "17", WeatherForecastType.LAND),
    GWANGMYEONG("11B10103", "광명", "Gwangmyeong", "31", "4", WeatherForecastType.LAND),
    GWACHEON("11B10102", "과천", "Gwacheon", "31", "3", WeatherForecastType.LAND);

    private final String code; //예보구역코드
    private final String name; //예보구역명
    private final String nameEng; // 예보구역명 (영문)
    private final String rsdCd1; // 관공공사 지역 공통 도/시 코드
    private final String rsdCd2; //관광공사 지역 공통 시/군/구 코드
    private final WeatherForecastType type;

    LandRegion(String code, String name, String nameEng, String rsdCd1, String rsdCd2, WeatherForecastType type) {
        this.code = code;
        this.name = name;
        this.nameEng = nameEng;
        this.rsdCd1 = rsdCd1;
        this.rsdCd2 = rsdCd2;
        this.type = type;
    }
}
