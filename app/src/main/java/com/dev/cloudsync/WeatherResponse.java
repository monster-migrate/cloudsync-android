package com.dev.cloudsync;

import java.util.List;

public class WeatherResponse {
    public List<WeatherModel> results;
    public String latitude;
    public String longitude;
    public String timezone_abbreviation;
    public CurrentWeather current;
    public String timezone;
    public CurrentUnits current_units;
    public DailyWeather daily;

    public WeatherResponse(List<WeatherModel> res) {
        this.results = res;
    }
    public List<WeatherModel> getResults() { return results; };
}
