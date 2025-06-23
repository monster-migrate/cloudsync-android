package com.dev.cloudsync;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LocationsInterface {
    @GET("search")
    Call<GeoResponse> getLocations(
            @Query("name") String name,
            @Query("count") int count,
            @Query("language") String language,
            @Query("format") String format
    );
}
