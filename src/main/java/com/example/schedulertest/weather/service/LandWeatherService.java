package com.example.schedulertest.weather.service;

import com.example.schedulertest.weather.cache.CacheService;
import com.example.schedulertest.weather.common.LandRegion;
import com.example.schedulertest.weather.dto.LandWeatherCacheValue;
import com.example.schedulertest.weather.dto.LandWeatherCacheValueItem;
import com.example.schedulertest.weather.vo.land.LandWeather;
import com.example.schedulertest.weather.vo.land.LandWeatherItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LandWeatherService {
    private static final String LAND_WEATHER_FORECAST_URI = "http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst";
    private static final String SERVICE_KEY = "GVMBX%2FSuhGPJ57sBMYmFUthO3khElaxmYX1VT%2FfD6ILyizzvDsUbhsq%2BM4Xr3MB7OJWvJ35MQu3qoRUWpEhz%2FA%3D%3D";
    private static final String JSON = "JSON";
    private static final String LAND_WEATHER_CACHE_KEY = "TOUR_WEATHER_LAND";

    private final CacheService cacheService;

    public LandWeatherService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    public void cacheLandWeather() {
        Map<String, LandWeatherCacheValue> landWeatherMap = new HashMap<>();
        for (LandRegion region : LandRegion.values()) {
            LandWeather landWeather = getLandWeather(region.getCode());
            LandWeatherCacheValue value = convertToLandWeatherCacheValue(landWeather.getResponse().getBody().getItems().getLandWeatherItems());
            landWeatherMap.put(region.getCode(), value);
        }

        cacheService.set(LAND_WEATHER_CACHE_KEY, landWeatherMap);
        log.info("### 육상 예보 조회 완료");
    }

    private LandWeatherCacheValue convertToLandWeatherCacheValue(List<LandWeatherItem> landWeatherItems) {
        String announceTime = landWeatherItems.get(0).getAnnounceTime();
        List<LandWeatherCacheValueItem> cacheValueItems = landWeatherItems.stream().map(LandWeatherCacheValueItem::from).collect(Collectors.toList());

        return LandWeatherCacheValue.builder().announceTime(announceTime).cacheValueItems(cacheValueItems).build();
    }

    private LandWeather getLandWeather(String regionCode) {
        return getLandWebClient().get().uri(uri -> uri.queryParam("serviceKey", SERVICE_KEY).queryParam("regId", regionCode).queryParam("dataType", JSON).build()).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(LandWeather.class).block();
    }

    private WebClient getLandWebClient() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(LAND_WEATHER_FORECAST_URI);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        return WebClient.builder().uriBuilderFactory(factory).build();
    }
}
