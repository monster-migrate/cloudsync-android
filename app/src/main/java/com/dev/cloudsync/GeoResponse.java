package com.dev.cloudsync;

import java.util.List;

public class GeoResponse {
    public List<LocationModel> results;
    public GeoResponse(List<LocationModel> res) {
        this.results = res;
    }
    public List<LocationModel> getResults() {
        return results;
    }
}