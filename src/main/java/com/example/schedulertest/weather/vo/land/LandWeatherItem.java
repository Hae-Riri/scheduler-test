package com.example.schedulertest.weather.vo.land;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LandWeatherItem {
    private String announceTime; // 발표시간

    @JsonProperty("numEf")
    private String dateCd; // 발표번호

    @JsonProperty("regId")
    private String regionCd; // 예보구역코드

    @JsonProperty("rnSt")
    private String rainPercentage; // 강수확률

    @JsonProperty("rnYn")
    private String rainForm; // 강수형태

    @JsonProperty("ta")
    private String temperature; // 예상기온

    @JsonProperty("wf")
    private String weatherDescription; // 날씨
}
