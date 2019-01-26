package com.rjt.b16couriertrackingsystem.map.network;

import com.rjt.b16couriertrackingsystem.map.model.Place;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceAPI {
    String BASE_URL = "https://maps.googleapis.com/";
//    https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=37.4219983,-122.084&radius=1500&keyword=fedex&key
    @GET("maps/api/place/nearbysearch/json")
    Call<Place> getPlaceResults(@Query("location") String location,
                                @Query("radius") Integer radius,
                                @Query("keyword") String keyword,
                                @Query("key") String key);
 }
