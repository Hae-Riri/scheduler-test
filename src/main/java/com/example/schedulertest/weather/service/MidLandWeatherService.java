package com.example.schedulertest.weather.service;

import com.example.schedulertest.weather.common.MidLandRegion;
import com.example.schedulertest.weather.vo.midland.MidLandWeather;
import com.example.schedulertest.weather.vo.midland.MidLandWeatherItems;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class MidLandWeatherService {
    private static final String MID_LAND_WEATHER_FORECAST_URI = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst";
    private static final String SERVICE_KEY = "GVMBX%2FSuhGPJ57sBMYmFUthO3khElaxmYX1VT%2FfD6ILyizzvDsUbhsq%2BM4Xr3MB7OJWvJ35MQu3qoRUWpEhz%2FA%3D%3D";
    private static final String JSON = "JSON";
    private static final String MID_LAND_WEATHER_CACHE_KEY = "TOUR_WEATHER_MID_LAND";

    public void cacheMidLandWeather() {
        Map<String, MidLandWeatherItems> midLandWeatherItemMap = new HashMap<>();
        for (MidLandRegion region : MidLandRegion.values()) {
            MidLandWeather midLandWeather = getMidLandWeather(region.getCode());
            midLandWeatherItemMap.put(region.getCode(), midLandWeather.getResponse().getBody().getItems());
        }

//        TourDHotelUtil.setRedisData(MID_LAND_WEATHER_CACHE_KEY, midLandWeatherItemMap, REDIS_MASTER_HOST, REDIS_MASTER_PORT);
        log.info("### 중기육상예보 완료");
    }

    private MidLandWeather getMidLandWeather(String regionCode) {
        return getWebClient().get()
                .uri(uri -> uri.queryParam("serviceKey", SERVICE_KEY)
                        .queryParam("regId", regionCode)
                        .queryParam("tmFc", "202204120600")
                        .queryParam("dataType", JSON)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(MidLandWeather.class)
                .block();
    }

    private WebClient getWebClient() {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(MID_LAND_WEATHER_FORECAST_URI);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        return WebClient.builder()
                .uriBuilderFactory(factory)
                .build();
    }
}
