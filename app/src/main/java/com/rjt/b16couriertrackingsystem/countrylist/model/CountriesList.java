package com.rjt.b16couriertrackingsystem.countrylist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountriesList {
    @SerializedName("Countries")
    List<Countries> countryList;

    public CountriesList(List<Countries> countryList) {
        this.countryList = countryList;
    }

    public List<Countries> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Countries> countryList) {
        this.countryList = countryList;
    }
}
