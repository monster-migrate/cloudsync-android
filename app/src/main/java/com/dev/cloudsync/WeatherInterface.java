package com.dev.cloudsync;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {
    @GET("forecast")
    Call<WeatherResponse> getWeather(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("daily") String daily,
            @Query("hourly") String hourly,
            @Query("current") String current,
            @Query("models") String models,
            @Query("timezone") String timezone,
            @Query("tilt") float tilt,
            @Query("azimuth") float azimuth,
            @Query("forecast_hours") int forecast_hours
    );
}
