package com.dev.cloudsync;

public class WeatherModel {
    public double latitude;
    public double longitude;
    public double generationtime_ms;
    public int utc_offset_seconds;
    public String timezone;
    public String timezone_abbreviation;
    public float elevation;
    public CurrentUnits current_units;
    public HourlyUnits hourly_units;
    public DailyUnits daily_units;
    public CurrentWeather current;
    public HourlyWeather hourly;
    public DailyWeather daily;

    public WeatherModel(double lat, double lon, String timezone) {
        this.latitude = lat;
        this.longitude = lon;
        this.timezone = timezone;
    }

    /*
     * https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41
     * &daily=
     * weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,
     * sunrise,sunset,daylight_duration,sunshine_duration,uv_index_max,uv_index_clear_sky_max,rain_sum,
     * showers_sum,snowfall_sum,precipitation_sum,precipitation_hours,precipitation_probability_max,
     * wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant,shortwave_radiation_sum,
     * et0_fao_evapotranspiration,temperature_2m_mean,apparent_temperature_mean,cape_mean,cape_max,
     * cape_min,cloud_cover_mean,cloud_cover_max,cloud_cover_min,dew_point_2m_mean,dew_point_2m_max,
     * dew_point_2m_min,et0_fao_evapotranspiration_sum,growing_degree_days_base_0_limit_50,
     * leaf_wetness_probability_mean,precipitation_probability_mean,precipitation_probability_min,
     * relative_humidity_2m_mean,relative_humidity_2m_max,relative_humidity_2m_min,snowfall_water_equivalent_sum,
     * pressure_msl_mean,pressure_msl_max,pressure_msl_min,surface_pressure_mean,surface_pressure_max,
     * surface_pressure_min,updraft_max,visibility_mean,visibility_min,visibility_max,winddirection_10m_dominant,
     * wind_gusts_10m_mean,wind_speed_10m_mean,wind_gusts_10m_min,wind_speed_10m_min,wet_bulb_temperature_2m_mean,
     * wet_bulb_temperature_2m_max,wet_bulb_temperature_2m_min,vapour_pressure_deficit_max
     *
     * &hourly=
     * temperature_2m,relative_humidity_2m,apparent_temperature,dew_point_2m,precipitation_probability,precipitation,rain,showers,
     * snowfall,snow_depth,weather_code,pressure_msl,surface_pressure,cloud_cover,cloud_cover_low,cloud_cover_mid,
     * cloud_cover_high,visibility,evapotranspiration,et0_fao_evapotranspiration,vapour_pressure_deficit,wind_speed_10m,
     * wind_speed_80m,wind_speed_120m,wind_speed_180m,wind_direction_10m,wind_direction_80m,wind_direction_120m,wind_direction_180m,
     * wind_gusts_10m,temperature_80m,temperature_120m,temperature_180m,soil_temperature_0cm,soil_temperature_6cm,soil_temperature_18cm,
     * soil_temperature_54cm,soil_moisture_0_to_1cm,soil_moisture_1_to_3cm,soil_moisture_3_to_9cm,soil_moisture_9_to_27cm,
     * soil_moisture_27_to_81cm,uv_index,uv_index_clear_sky,is_day,sunshine_duration,wet_bulb_temperature_2m,total_column_integrated_water_vapour,
     * cape,lifted_index,convective_inhibition,freezing_level_height,boundary_layer_height,shortwave_radiation,direct_radiation,
     * diffuse_radiation,direct_normal_irradiance,global_tilted_irradiance,terrestrial_radiation,shortwave_radiation_instant,
     * direct_radiation_instant,diffuse_radiation_instant,direct_normal_irradiance_instant,global_tilted_irradiance_instant,
     * terrestrial_radiation_instant
     * &models=best_match
     * &current=temperature_2m,relative_humidity_2m,apparent_temperature,
     * is_day,precipitation,rain,showers,snowfall,weather_code,cloud_cover,surface_pressure,wind_speed_10m,wind_direction_10m,
     * pressure_msl,wind_gusts_10m
     * &timezone=auto
     * &tilt=30
     * &azimuth=180
     * &forecast_hours=6
     */
}
