package com.dev.cloudsync;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private LocationsAdapter locAdapter;
    private Retrofit retrofit;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable searchRunnable;
    private Call<GeoResponse> currentCall;
    private double longitude=0.0f, latitude=0.0f;
    @SuppressLint("ApplySharedPref")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences prefs = getSharedPreferences("com.dev.cloudsync", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        if (prefs.contains("longitude") && prefs.contains("latitude") && prefs.contains("location")) {
            String location = prefs.getString("location", null);
            if (location != null && !location.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, WeatherView.class);
                startActivity(intent);
            }
        }
        ImageView searchBtn = findViewById(R.id.search);
        EditText searchText = findViewById(R.id.searchbox);
        // TODO remove debug comments
        // build config works
        RecyclerView locations_recycler_view = findViewById(R.id.location_recycler_view);
        locations_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        locations_recycler_view.setVisibility(View.GONE);
        List<LocationModel> locationsList = new ArrayList<LocationModel>();
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 3) {
                    if (searchRunnable != null) handler.removeCallbacks(searchRunnable);
                    searchRunnable = () -> {
                        if (retrofit == null) {
                            retrofit = new Retrofit.Builder()
                                    .baseUrl(BuildConfig.LOCATION_API_BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                        }

                        LocationsInterface api = retrofit.create(LocationsInterface.class);
                        if (currentCall != null && !currentCall.isCanceled()) {
                            currentCall.cancel(); // Cancel any ongoing call
                        }

                        currentCall = api.getLocations(s.toString(), 5, "en", "json");

                        currentCall.enqueue(new Callback<GeoResponse>() {
                            @SuppressLint("NotifyDataSetChanged")
                            @Override
                            public void onResponse(@NonNull Call<GeoResponse> call, @NonNull Response<GeoResponse> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    List<LocationModel> values = response.body().getResults();
                                    if (values != null && !values.isEmpty()) {
                                        locationsList.clear();
                                        locationsList.addAll(values);
                                        locations_recycler_view.setVisibility(View.VISIBLE);
                                        locAdapter.notifyDataSetChanged();

                                        for (LocationModel value : values) {
                                            Log.d("geo call", Arrays.toString(
                                                    new String[]{value.name, String.valueOf(value.longitude), String.valueOf(value.latitude), value.country}
                                            ));
                                        }
                                    } else {
                                        // Optional: show "no results" message or clear the list
                                        locationsList.clear();
                                        locationsList.add(new LocationModel("Nothing Found!", 0, 0, " Please try again"));
                                        locations_recycler_view.setVisibility(View.VISIBLE);
                                        locAdapter.notifyDataSetChanged();
                                        Log.d("geo call", "No results found");
                                    }
                                }
                            }

                            @Override
                            public void onFailure(@NonNull Call<GeoResponse> call, @NonNull Throwable t) {
                                if (!call.isCanceled()) {
                                    Log.e("geo call", "Request failed", t);
                                }
                            }
                        });
                    };
                    handler.postDelayed(searchRunnable, 500);
                } else {
                    locations_recycler_view.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        searchBtn.setOnClickListener(v -> {
            // TODO implement search button
            Toast.makeText(this, longitude+","+latitude+","
                    +(locationsList.isEmpty()?"GMT":locationsList.get(0).timezone), Toast.LENGTH_SHORT).show();

            editor.putFloat("longitude", (float)longitude);
            editor.putFloat("latitude", (float)latitude);
            editor.commit();

            Intent i = new Intent(MainActivity.this, WeatherView.class);
            startActivity(i);
        });

        locAdapter = new LocationsAdapter(locationsList, (locationText, lon, lat) -> {
            searchText.setText(locationText);
            searchText.setSelection(searchText.getText().length());
            editor.putString("location",locationText);
            editor.commit();
            longitude = lon;
            latitude = lat;
        });
        locations_recycler_view.setAdapter(locAdapter);
    }
}