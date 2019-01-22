package com.rjt.b16couriertrackingsystem.countrylist.model;

import com.google.gson.annotations.SerializedName;

public class Countries {
    @SerializedName("id")
    String id;
    @SerializedName("countrycode")
    String countrycode;
    @SerializedName("countryname")
    String countryname;

    public Countries(String id, String countrycode, String countryname) {
        this.id = id;
        this.countrycode = countrycode;
        this.countryname = countryname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
