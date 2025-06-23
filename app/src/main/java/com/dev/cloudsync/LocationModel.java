package com.dev.cloudsync;

public class LocationModel {
    public String name;
    public double latitude;
    public double longitude;
    public String country;
    public String admin1;
    public String timezone;

    public LocationModel(String name, double longitude, double latitude, String country) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
    }
}
