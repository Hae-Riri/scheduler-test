package com.example.schedulertest.weather.dto;

import com.example.schedulertest.weather.vo.land.LandWeatherItem;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LandWeatherCacheValueItem {

    private String dateCd; // 발표번호(오늘오전, 모레오후 등을 구분)
    private String rainPercentage; // 강수확률
    private String rainForm; // 강수형태
    private String temperature; // 예상기온
    private String weatherDescription; // 날씨

    public static LandWeatherCacheValueItem from(LandWeatherItem landWeatherItem) {
        return LandWeatherCacheValueItem.builder()
                .dateCd(landWeatherItem.getDateCd())
                .rainPercentage(landWeatherItem.getRainPercentage())
                .rainForm(landWeatherItem.getRainForm())
                .temperature(landWeatherItem.getTemperature())
                .weatherDescription(landWeatherItem.getWeatherDescription())
                .build();
    }
}
