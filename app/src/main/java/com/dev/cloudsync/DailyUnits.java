package com.dev.cloudsync;

import com.google.gson.annotations.SerializedName;

public class DailyUnits {
    @SerializedName("time")
    public String time;

    @SerializedName("weather_code")
    public String weatherCode;

    @SerializedName("temperature_2m_max")
    public String temperature2mMax;

    @SerializedName("temperature_2m_min")
    public String temperature2mMin;

    @SerializedName("apparent_temperature_max")
    public String apparentTemperatureMax;

    @SerializedName("apparent_temperature_min")
    public String apparentTemperatureMin;

    @SerializedName("sunrise")
    public String sunrise;

    @SerializedName("sunset")
    public String sunset;

    @SerializedName("daylight_duration")
    public String daylightDuration;

    @SerializedName("sunshine_duration")
    public String sunshineDuration;

    @SerializedName("uv_index_max")
    public String uvIndexMax;

    @SerializedName("uv_index_clear_sky_max")
    public String uvIndexClearSkyMax;

    @SerializedName("rain_sum")
    public String rainSum;

    @SerializedName("showers_sum")
    public String showersSum;

    @SerializedName("snowfall_sum")
    public String snowfallSum;

    @SerializedName("precipitation_sum")
    public String precipitationSum;

    @SerializedName("precipitation_hours")
    public String precipitationHours;

    @SerializedName("precipitation_probability_max")
    public String precipitationProbabilityMax;

    @SerializedName("wind_speed_10m_max")
    public String windSpeed10mMax;

    @SerializedName("wind_gusts_10m_max")
    public String windGusts10mMax;

    @SerializedName("wind_direction_10m_dominant")
    public String windDirection10mDominant;

    @SerializedName("shortwave_radiation_sum")
    public String shortwaveRadiationSum;

    @SerializedName("et0_fao_evapotranspiration")
    public String et0FaoEvapotranspiration;

    @SerializedName("temperature_2m_mean")
    public String temperature2mMean;

    @SerializedName("apparent_temperature_mean")
    public String apparentTemperatureMean;

    @SerializedName("cape_mean")
    public String capeMean;

    @SerializedName("cape_max")
    public String capeMax;

    @SerializedName("cape_min")
    public String capeMin;

    @SerializedName("cloud_cover_mean")
    public String cloudCoverMean;

    @SerializedName("cloud_cover_max")
    public String cloudCoverMax;

    @SerializedName("cloud_cover_min")
    public String cloudCoverMin;

    @SerializedName("dew_point_2m_mean")
    public String dewPoint2mMean;

    @SerializedName("dew_point_2m_max")
    public String dewPoint2mMax;

    @SerializedName("dew_point_2m_min")
    public String dewPoint2mMin;

    @SerializedName("et0_fao_evapotranspiration_sum")
    public String et0FaoEvapotranspirationSum;

    @SerializedName("growing_degree_days_base_0_limit_50")
    public String growingDegreeDaysBase0Limit50;

    @SerializedName("leaf_wetness_probability_mean")
    public String leafWetnessProbabilityMean;

    @SerializedName("precipitation_probability_mean")
    public String precipitationProbabilityMean;

    @SerializedName("precipitation_probability_min")
    public String precipitationProbabilityMin;

    @SerializedName("relative_humidity_2m_mean")
    public String relativeHumidity2mMean;

    @SerializedName("relative_humidity_2m_max")
    public String relativeHumidity2mMax;

    @SerializedName("relative_humidity_2m_min")
    public String relativeHumidity2mMin;

    @SerializedName("snowfall_water_equivalent_sum")
    public String snowfallWaterEquivalentSum;

    @SerializedName("pressure_msl_mean")
    public String pressureMslMean;

    @SerializedName("pressure_msl_max")
    public String pressureMslMax;

    @SerializedName("pressure_msl_min")
    public String pressureMslMin;

    @SerializedName("surface_pressure_mean")
    public String surfacePressureMean;

    @SerializedName("surface_pressure_max")
    public String surfacePressureMax;

    @SerializedName("surface_pressure_min")
    public String surfacePressureMin;

    @SerializedName("updraft_max")
    public String updraftMax;

    @SerializedName("visibility_mean")
    public String visibilityMean;

    @SerializedName("visibility_min")
    public String visibilityMin;

    @SerializedName("visibility_max")
    public String visibilityMax;

    @SerializedName("winddirection_10m_dominant")
    public String windDirection10mDominantAlt; // in case server returns alternate spelling

    @SerializedName("wind_gusts_10m_mean")
    public String windGusts10mMean;

    @SerializedName("wind_speed_10m_mean")
    public String windSpeed10mMean;

    @SerializedName("wind_gusts_10m_min")
    public String windGusts10mMin;

    @SerializedName("wind_speed_10m_min")
    public String windSpeed10mMin;

    @SerializedName("wet_bulb_temperature_2m_mean")
    public String wetBulbTemperature2mMean;

    @SerializedName("wet_bulb_temperature_2m_max")
    public String wetBulbTemperature2mMax;

    @SerializedName("wet_bulb_temperature_2m_min")
    public String wetBulbTemperature2mMin;

    @SerializedName("vapour_pressure_deficit_max")
    public String vapourPressureDeficitMax;
}
