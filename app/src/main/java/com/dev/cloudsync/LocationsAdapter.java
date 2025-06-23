package com.dev.cloudsync;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder> {
    private List<LocationModel> locationsList;
    private OnLocationClickListener listener;

    public static class LocationsViewHolder extends RecyclerView.ViewHolder {
        public TextView location;
        public LocationsViewHolder(View v) {
            super(v);
            location = v.findViewById(R.id.location_item);
        }
    }

    public LocationsAdapter(List<LocationModel> locations, OnLocationClickListener listener) {
        this.locationsList = locations;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LocationsAdapter.LocationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_item, parent, false);
        return new LocationsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationsViewHolder holder, int position) {
        LocationModel loc = locationsList.get(position);
        StringBuilder locationTextBuilder = new StringBuilder();
        if (loc.name != null) locationTextBuilder.append(loc.name);
        if (loc.admin1 != null) locationTextBuilder.append(", ").append(loc.admin1);
        if (loc.country != null) locationTextBuilder.append(", ").append(loc.country);
        String locationText = locationTextBuilder.toString();

        double longitude = locationsList.get(position).longitude;
        double latitude = locationsList.get(position).latitude;
        holder.location.setText(locationText);
        holder.location.setOnClickListener(v -> {
            if(listener!=null){
                listener.onLocationClick(locationText, longitude, latitude);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locationsList.size();
    }
}
