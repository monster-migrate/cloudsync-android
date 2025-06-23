package com.dev.cloudsync;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherView extends AppCompatActivity {

    private Retrofit retrofit;
    private WeatherResponse weatherData;
    ShimmerFrameLayout shimmerLayout;
    ShimmerFrameLayout shimmerIconLayout;
    ShimmerFrameLayout shimmerWeatherDescr;
    ShimmerFrameLayout shimmerCurrentWeatherData;
    ShimmerFrameLayout shimmerPWD;
    TextView localeInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences prefs = getSharedPreferences("com.dev.cloudsync", Context.MODE_PRIVATE);
        float lon = prefs.getFloat("longitude", 0.0f);
        float lat = prefs.getFloat("latitude", 0.0f);

        shimmerLayout = findViewById(R.id.shimmer_locale);
        shimmerIconLayout = findViewById(R.id.shimmer_icon);
        shimmerWeatherDescr = findViewById(R.id.weather_descr_shimmer);
        shimmerCurrentWeatherData = findViewById(R.id.current_weather_shimmer);
        shimmerPWD = findViewById(R.id.pwd_shimmer);
        localeInfo = findViewById(R.id.locale_info);

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.WEATHER_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherInterface api = retrofit.create(WeatherInterface.class);

        String daily = "weather_code,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min," +
                "sunrise,sunset,daylight_duration,sunshine_duration,uv_index_max,uv_index_clear_sky_max,rain_sum," +
                "showers_sum,snowfall_sum,precipitation_sum,precipitation_hours,precipitation_probability_max," +
                "wind_speed_10m_max,wind_gusts_10m_max,wind_direction_10m_dominant,shortwave_radiation_sum," +
                "et0_fao_evapotranspiration,temperature_2m_mean,apparent_temperature_mean,cape_mean,cape_max," +
                "cape_min,cloud_cover_mean,cloud_cover_max,cloud_cover_min,dew_point_2m_mean,dew_point_2m_max," +
                "dew_point_2m_min,et0_fao_evapotranspiration_sum,growing_degree_days_base_0_limit_50," +
                "leaf_wetness_probability_mean,precipitation_probability_mean,precipitation_probability_min," +
                "relative_humidity_2m_mean,relative_humidity_2m_max,relative_humidity_2m_min,snowfall_water_equivalent_sum," +
                "pressure_msl_mean,pressure_msl_max,pressure_msl_min,surface_pressure_mean,surface_pressure_max," +
                "surface_pressure_min,updraft_max,visibility_mean,visibility_min,visibility_max,winddirection_10m_dominant," +
                "wind_gusts_10m_mean,wind_speed_10m_mean,wind_gusts_10m_min,wind_speed_10m_min,wet_bulb_temperature_2m_mean," +
                "wet_bulb_temperature_2m_max,wet_bulb_temperature_2m_min,vapour_pressure_deficit_max";
        String hourly = "temperature_2m,relative_humidity_2m,apparent_temperature,dew_point_2m,precipitation_probability,precipitation,rain,showers," +
                "snowfall,snow_depth,weather_code,pressure_msl,surface_pressure,cloud_cover,cloud_cover_low,cloud_cover_mid," +
                "cloud_cover_high,visibility,evapotranspiration,et0_fao_evapotranspiration,vapour_pressure_deficit,wind_speed_10m," +
                "wind_speed_80m,wind_speed_120m,wind_speed_180m,wind_direction_10m,wind_direction_80m,wind_direction_120m,wind_direction_180m," +
                "wind_gusts_10m,temperature_80m,temperature_120m,temperature_180m,soil_temperature_0cm,soil_temperature_6cm,soil_temperature_18cm," +
                "soil_temperature_54cm,soil_moisture_0_to_1cm,soil_moisture_1_to_3cm,soil_moisture_3_to_9cm,soil_moisture_9_to_27cm," +
                "soil_moisture_27_to_81cm,uv_index,uv_index_clear_sky,is_day,sunshine_duration,wet_bulb_temperature_2m,total_column_integrated_water_vapour," +
                "cape,lifted_index,convective_inhibition,freezing_level_height,boundary_layer_height,shortwave_radiation,direct_radiation," +
                "diffuse_radiation,direct_normal_irradiance,global_tilted_irradiance,terrestrial_radiation,shortwave_radiation_instant," +
                "direct_radiation_instant,diffuse_radiation_instant,direct_normal_irradiance_instant,global_tilted_irradiance_instant,terrestrial_radiation_instant";
        String current = "temperature_2m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,showers,snowfall,weather_code,cloud_cover,surface_pressure,wind_speed_10m,wind_direction_10m,pressure_msl,wind_gusts_10m";
        String models = "best_match";
        String timezone = "auto";
        float tilt = 0.0f;
        float azimuth = 0.0f;
        int forecast_hours = 6;
        Call<WeatherResponse> call = api.getWeather(
                lat,lon,
                daily,
                hourly,
                current,
                models,
                timezone,
                tilt,
                azimuth,
                forecast_hours);
        Log.d("requestxyz123", call.request().toString());
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    weatherData = response.body();
                    updateWeatherUI(weatherData, prefs);
                    TextView daylightDuration = findViewById(R.id.daylight_duration);
                    int totalSeconds = (int) Math.round(weatherData.daily.daylight_duration.get(0));
                    int hours = totalSeconds / 3600;
                    int minutes = (totalSeconds % 3600) / 60;

                    String daylight = hours + " hours and " + minutes + " minutes of daylight duration.";
                    daylightDuration.setText(daylight);
                } else {
                    runOnUiThread(() -> localeInfo.setText("Response error: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                runOnUiThread(() -> localeInfo.setText("Network error: " + t.getMessage()));
            }
        });
    }

    private int setWeatherIcon(int weatherCode, int isDay) {
        int currentWeather = R.drawable.ioiossunny;
        switch (weatherCode) {
            case 0:
                currentWeather = (isDay == 1)
                        ? R.drawable.ioiossunny
                        : R.drawable.winightclear;
                break;

            case 1:
            case 2:
            case 3:
                currentWeather = (isDay == 1)
                        ? R.drawable.iopartylysunny
                        : R.drawable.winightaltpartlycloudy;
                break;

            case 45:
            case 48:
                currentWeather = (isDay == 1)
                        ? R.drawable.widayfog
                        : R.drawable.winightfog;
                break;

            case 51:
            case 53:
            case 55:
            case 56:
            case 57:
            case 61:
            case 63:
            case 65:
            case 66:
            case 67:
            case 80:
            case 81:
            case 82:
                currentWeather = (isDay == 1)
                        ? R.drawable.wirain
                        : R.drawable.winightaltrain;
                break;

            case 71:
            case 73:
            case 75:
            case 85:
            case 86:
                currentWeather = (isDay == 1)
                        ? R.drawable.wisnow
                        : R.drawable.winightaltsnow;
                break;

            case 95:
            case 96:
            case 99:
                currentWeather = (isDay == 1)
                        ? R.drawable.withunderstorm
                        : R.drawable.winightaltthunderstorm;
                break;

            default:
                currentWeather = R.drawable.ioiossunny;
                break;
        }
        return currentWeather;
    }
    public String getWeatherDescription(int code) {
        switch (code) {
            case 0:
                return "Clear sky";
            case 1:
            case 2:
            case 3:
                return "Mainly clear, partly cloudy, and overcast";
            case 45:
            case 48:
                return "Fog and depositing rime fog";
            case 51:
            case 53:
            case 55:
                return "Drizzle: Light, moderate, and dense intensity";
            case 56:
            case 57:
                return "Freezing Drizzle: Light and dense intensity";
            case 61:
            case 63:
            case 65:
                return "Rain: Slight, moderate and heavy intensity";
            case 66:
            case 67:
                return "Freezing Rain: Light and heavy intensity";
            case 71:
            case 73:
            case 75:
                return "Snow fall: Slight, moderate, and heavy intensity";
            case 77:
                return "Snow grains";
            case 80:
            case 81:
            case 82:
                return "Rain showers: Slight, moderate, and violent";
            case 85:
            case 86:
                return "Snow showers slight and heavy";
            case 95:
                return "Thunderstorm: Slight or moderate";
            case 96:
            case 99:
                return "Thunderstorm with slight and heavy hail";
            default:
                return "Unknown weather condition";
        }
    }
    private void stopShimmerAndReveal(View shimmerLayout, View actualView) {
        if (shimmerLayout instanceof com.facebook.shimmer.ShimmerFrameLayout) {
            ((com.facebook.shimmer.ShimmerFrameLayout) shimmerLayout).stopShimmer();
        }
        shimmerLayout.setVisibility(View.GONE);
        actualView.setVisibility(View.VISIBLE);
    }
    private void updateTextViewWithData(ShimmerFrameLayout shimmer, TextView view, String text) {
        stopShimmerAndReveal(shimmer, view);
        view.setBackgroundColor(Color.TRANSPARENT);
        view.setText(text);
    }
    private void updateImageViewWithDrawable(ShimmerFrameLayout shimmer, ImageView view, int drawableId) {
        stopShimmerAndReveal(shimmer, view);
        view.setImageDrawable(ContextCompat.getDrawable(this, drawableId));
    }
    private String formatDateTime(String time, String zone) {
        LocalDateTime localDateTime = LocalDateTime.parse(time);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(zone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy 'at' hh:mm a", Locale.ENGLISH);
        return formatter.format(zonedDateTime);
    }

    private void updateWeatherUI(WeatherResponse weatherData, SharedPreferences prefs) {
        int weatherCode = weatherData.current.weather_code;
        int isDay = weatherData.current.isDay;
        int iconRes = setWeatherIcon(weatherCode, isDay);
        String formattedTime = formatDateTime(weatherData.current.time, weatherData.timezone);

        String info = prefs.getString("location", "") + "\n" + formattedTime;

        runOnUiThread(() -> {
            updateTextViewWithData(shimmerLayout, localeInfo, info);
            updateImageViewWithDrawable(shimmerIconLayout, findViewById(R.id.weather_icon), iconRes);
            updateTextViewWithData(shimmerWeatherDescr, findViewById(R.id.weather_descr), getWeatherDescription(weatherCode));

            updateImageViewWithDrawable(shimmerCurrentWeatherData, findViewById(R.id.current_weather), setWeatherIcon(weatherCode, isDay));

            TextView apparentTemperature =  findViewById(R.id.apparant_temperature);
            apparentTemperature.setVisibility(View.VISIBLE);
            String appTemp = "Feels like " + weatherData.current.apparentTemperature + weatherData.current_units.temperature_2m;
            apparentTemperature.setText(appTemp);
            TextView temperatureUnits = findViewById(R.id.temperature_unit);
            temperatureUnits.setText(weatherData.current_units.temperature_2m);
            temperatureUnits.setVisibility(View.VISIBLE);
            String temperature2m = weatherData.current.temperature2m+"";
            updateTextViewWithData(shimmerPWD, findViewById(R.id.temperature), temperature2m);
        });
    }
}