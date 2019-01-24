package com.rjt.b16couriertrackingsystem.countrylist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.countrylist.model.Countries;

import java.util.ArrayList;
import java.util.List;

public class MyCountryAdapter extends RecyclerView.Adapter<MyCountryAdapter.MyViewHolder> implements Filterable {

    List<Countries> myCountries = new ArrayList<>();
    List<Countries> countriesFiltered;

    public MyCountryAdapter(List<Countries> myCountries) {
        this.myCountries = myCountries;
    }

    @NonNull
    @Override
    public MyCountryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.countrylist_view_item, viewGroup, false);

        return new MyViewHolder(view);
    }


    public class MyViewHolder extends ViewHolder {
        public TextView vAlbumId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vAlbumId = itemView.findViewById(R.id.textViewCountryName);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyCountryAdapter.MyViewHolder myViewHolder, int i) {
//        List<Countries> list = myCountries;
        final Countries country = myCountries.get(i);
        myViewHolder.vAlbumId.setText(country.getCountryname());
        
        myViewHolder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), country.getCountryname(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myCountries.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                List<Countries> filtered = new ArrayList<>();

                if (charString.isEmpty()) {
                    filtered = myCountries;
                } else {
                    for (Countries i : myCountries) {
                        if (i.getCountryname().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            filtered.add(i);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.count = filtered.size();
                filterResults.values = filtered;
//                Log.i("xxx", filteredList.get(0).getCountryname());
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                myCountries = (List<Countries>) filterResults.values;

//                Log.i("xxx", myCountries.getCountryList().toString());
                notifyDataSetChanged();
            }
        };
    }
}