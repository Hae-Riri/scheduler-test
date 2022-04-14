package com.example.schedulertest.weather.vo.midland;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MidLandWeatherItem {
    @JsonProperty("rnSt3Am")
    private String rainPercentage3Am;

    @JsonProperty("rnSt3Pm")
    private String rainPercentage3Pm;

    @JsonProperty("rnSt4Am")
    private String rainPercentage4Am;

    @JsonProperty("rnSt4Pm")
    private String rainPercentage4Pm;

    @JsonProperty("rnSt5Am")
    private String rainPercentage5Am;

    @JsonProperty("rnSt6Pm")
    private String rainPercentage6Pm;

    @JsonProperty("rnSt7Am")
    private String rainPercentage7Am;

    @JsonProperty("rnSt8")
    private String rainPercentage8;

    @JsonProperty("rnSt9")
    private String rainPercentage9;

    @JsonProperty("rnSt10")
    private String rainPercentage10;

    @JsonProperty("wf3Am")
    private String weatherDescription3Am;

    @JsonProperty("wf3Pm")
    private String weatherDescription3Pm;

    @JsonProperty("wf4Am")
    private String weatherDescription4Am;

    @JsonProperty("wf4Pm")
    private String weatherDescription4Pm;

    @JsonProperty("wf5Am")
    private String weatherDescription5Am;

    @JsonProperty("wf5Pm")
    private String weatherDescription5Pm;

    @JsonProperty("wf6Am")
    private String weatherDescription6Am;

    @JsonProperty("wf6Pm")
    private String weatherDescription7Pm;

    @JsonProperty("wf7Am")
    private String weatherDescription8Am;

    @JsonProperty("wf7Pm")
    private String weatherDescription9Pm;

    @JsonProperty("wf8")
    private String weatherDescription8;

    @JsonProperty("wf9")
    private String weatherDescription9;

    @JsonProperty("wf10")
    private String weatherDescription10;
}
