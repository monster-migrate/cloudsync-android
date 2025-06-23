package com.dev.cloudsync;

import com.google.gson.annotations.SerializedName;

public class HourlyUnits {
    @SerializedName("time")
    public String time;

    @SerializedName("temperature_2m")
    public String temperature2m;

    @SerializedName("relative_humidity_2m")
    public String relativeHumidity2m;

    @SerializedName("apparent_temperature")
    public String apparentTemperature;

    @SerializedName("dew_point_2m")
    public String dewPoint2m;

    @SerializedName("precipitation_probability")
    public String precipitationProbability;

    @SerializedName("precipitation")
    public String precipitation;

    @SerializedName("rain")
    public String rain;

    @SerializedName("showers")
    public String showers;

    @SerializedName("snowfall")
    public String snowfall;

    @SerializedName("snow_depth")
    public String snowDepth;

    @SerializedName("weather_code")
    public String weatherCode;

    @SerializedName("pressure_msl")
    public String pressureMsl;

    @SerializedName("surface_pressure")
    public String surfacePressure;

    @SerializedName("cloud_cover")
    public String cloudCover;

    @SerializedName("cloud_cover_low")
    public String cloudCoverLow;

    @SerializedName("cloud_cover_mid")
    public String cloudCoverMid;

    @SerializedName("cloud_cover_high")
    public String cloudCoverHigh;

    @SerializedName("visibility")
    public String visibility;

    @SerializedName("evapotranspiration")
    public String evapotranspiration;

    @SerializedName("et0_fao_evapotranspiration")
    public String et0FaoEvapotranspiration;

    @SerializedName("vapour_pressure_deficit")
    public String vapourPressureDeficit;

    @SerializedName("wind_speed_10m")
    public String windSpeed10m;

    @SerializedName("wind_speed_80m")
    public String windSpeed80m;

    @SerializedName("wind_speed_120m")
    public String windSpeed120m;

    @SerializedName("wind_speed_180m")
    public String windSpeed180m;

    @SerializedName("wind_direction_10m")
    public String windDirection10m;

    @SerializedName("wind_direction_80m")
    public String windDirection80m;

    @SerializedName("wind_direction_120m")
    public String windDirection120m;

    @SerializedName("wind_direction_180m")
    public String windDirection180m;

    @SerializedName("wind_gusts_10m")
    public String windGusts10m;

    @SerializedName("temperature_80m")
    public String temperature80m;

    @SerializedName("temperature_120m")
    public String temperature120m;

    @SerializedName("temperature_180m")
    public String temperature180m;

    @SerializedName("soil_temperature_0cm")
    public String soilTemperature0cm;

    @SerializedName("soil_temperature_6cm")
    public String soilTemperature6cm;

    @SerializedName("soil_temperature_18cm")
    public String soilTemperature18cm;

    @SerializedName("soil_temperature_54cm")
    public String soilTemperature54cm;

    @SerializedName("soil_moisture_0_to_1cm")
    public String soilMoisture0To1cm;

    @SerializedName("soil_moisture_1_to_3cm")
    public String soilMoisture1To3cm;

    @SerializedName("soil_moisture_3_to_9cm")
    public String soilMoisture3To9cm;

    @SerializedName("soil_moisture_9_to_27cm")
    public String soilMoisture9To27cm;

    @SerializedName("soil_moisture_27_to_81cm")
    public String soilMoisture27To81cm;

    @SerializedName("uv_index")
    public String uvIndex;

    @SerializedName("uv_index_clear_sky")
    public String uvIndexClearSky;

    @SerializedName("is_day")
    public String isDay;

    @SerializedName("sunshine_duration")
    public String sunshineDuration;

    @SerializedName("wet_bulb_temperature_2m")
    public String wetBulbTemperature2m;

    @SerializedName("total_column_integrated_water_vapour")
    public String totalColumnIntegratedWaterVapour;

    @SerializedName("cape")
    public String cape;

    @SerializedName("lifted_index")
    public String liftedIndex;

    @SerializedName("convective_inhibition")
    public String convectiveInhibition;

    @SerializedName("freezing_level_height")
    public String freezingLevelHeight;

    @SerializedName("boundary_layer_height")
    public String boundaryLayerHeight;

    @SerializedName("shortwave_radiation")
    public String shortwaveRadiation;

    @SerializedName("direct_radiation")
    public String directRadiation;

    @SerializedName("diffuse_radiation")
    public String diffuseRadiation;

    @SerializedName("direct_normal_irradiance")
    public String directNormalIrradiance;

    @SerializedName("global_tilted_irradiance")
    public String globalTiltedIrradiance;

    @SerializedName("terrestrial_radiation")
    public String terrestrialRadiation;

    @SerializedName("shortwave_radiation_instant")
    public String shortwaveRadiationInstant;

    @SerializedName("direct_radiation_instant")
    public String directRadiationInstant;

    @SerializedName("diffuse_radiation_instant")
    public String diffuseRadiationInstant;

    @SerializedName("direct_normal_irradiance_instant")
    public String directNormalIrradianceInstant;

    @SerializedName("global_tilted_irradiance_instant")
    public String globalTiltedIrradianceInstant;

    @SerializedName("terrestrial_radiation_instant")
    public String terrestrialRadiationInstant;
}
