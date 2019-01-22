package com.rjt.b16couriertrackingsystem.countrylist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.countrylist.model.Countries;
import com.rjt.b16couriertrackingsystem.countrylist.model.CountriesList;

import java.util.ArrayList;
import java.util.List;

public class MyCountryListAdapter extends RecyclerView.Adapter<MyCountryListAdapter.MyViewHolder>
    implements Filterable {

    CountriesList myCountries;
    CountriesList myList;
    List<Countries> filteredList = new ArrayList<>();
    List<Countries> itemsFiltered;

    public MyCountryListAdapter(CountriesList myCountries) {
        this.myCountries = myCountries;
    }

    @NonNull
    @Override
    public MyCountryListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
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
    public void onBindViewHolder(@NonNull MyCountryListAdapter.MyViewHolder myViewHolder, int i) {
        CountriesList list = myCountries;

        myViewHolder.vAlbumId.setText(list.getCountryList().get(i).getCountryname());
    }

    @Override
    public int getItemCount() {
        return myCountries.getCountryList().size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    filteredList = myCountries.getCountryList();
                } else {
                    for (Countries i : myCountries.getCountryList()) {
                        if (i.getCountryname().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            filteredList.add(i);
                            Log.i("xxx", i.getCountryname());
                        }
                    }
//                    myList = (CountriesList) filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.count = filteredList.size();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                itemsFiltered = (List<Countries>) filterResults.values;
                //Log.i("xxx", String.valueOf(filteredList.size()));
                notifyDataSetChanged();
            }
        };
    }
}