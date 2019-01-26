package com.rjt.b16couriertrackingsystem.map;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.map.model.Result;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.MyViewHolder> {

    List<Result> myPlaces;
    TextView nearbyName, nearbyVin, nearbyRating, nearbyOpening;


    public NearbyAdapter(List<Result> myPlaces) {
        this.myPlaces = myPlaces;
    }

    @NonNull
    @Override
    public NearbyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nearby_list_row_item, viewGroup, false);

        return new MyViewHolder(view);
    }


    public class MyViewHolder extends ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nearbyName = itemView.findViewById(R.id.textViewNearbyName);
            nearbyVin = itemView.findViewById(R.id.textViewNearbyVin);
            nearbyRating = itemView.findViewById(R.id.textViewNearbyRating);
            nearbyOpening = itemView.findViewById(R.id.textViewNearbyOpening);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyAdapter.MyViewHolder myViewHolder, int i) {
        final Result result = myPlaces.get(i);
        nearbyName.setText(result.getName());
        nearbyVin.setText(result.getVicinity());
        nearbyRating.setText(result.getRating().toString());
        nearbyOpening.setText("Opening now? " + result.getOpeningHours().getOpenNow());

    }

    @Override
    public int getItemCount() {
        return myPlaces.size();
    }

}