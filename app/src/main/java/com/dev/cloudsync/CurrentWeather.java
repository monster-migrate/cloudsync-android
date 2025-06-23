package com.dev.cloudsync;

import com.google.gson.annotations.SerializedName;

public class CurrentWeather {

    @SerializedName("time")
    public String time;

    @SerializedName("interval")
    public int interval;

    @SerializedName("temperature_2m")
    public double temperature2m;

    @SerializedName("relative_humidity_2m")
    public int relativeHumidity2m;

    @SerializedName("apparent_temperature")
    public double apparentTemperature;

    @SerializedName("is_day")
    public int isDay;

    @SerializedName("precipitation")
    public double precipitation;

    @SerializedName("rain")
    public double rain;

    @SerializedName("showers")
    public double showers;

    @SerializedName("snowfall")
    public double snowfall;

    @SerializedName("weather_code")
    public int weather_code;

    @SerializedName("cloud_cover")
    public int cloudCover;

    @SerializedName("surface_pressure")
    public double surfacePressure;

    @SerializedName("wind_speed_10m")
    public double windSpeed10m;

    @SerializedName("wind_direction_10m")
    public int windDirection10m;

    @SerializedName("pressure_msl")
    public double pressureMsl;

    @SerializedName("wind_gusts_10m")
    public double windGusts10m;
}
