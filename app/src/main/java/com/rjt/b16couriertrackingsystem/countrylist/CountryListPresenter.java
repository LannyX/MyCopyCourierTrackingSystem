package com.rjt.b16couriertrackingsystem.countrylist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rjt.b16couriertrackingsystem.countrylist.model.CountriesList;
import com.rjt.b16couriertrackingsystem.countrylist.network.GetCountryListService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryListPresenter implements CountryListContract.CountryListPresenter{
    final String TAG = CountryListPresenter.class.getSimpleName();
    GetCountryListService getCountryListService;
    CountriesList countriesList;
    RecyclerView recyclerView;
    MyCountryAdapter myCountryAdapter;


    @Override
    public void getCountryList() {
        getCountryListService = RetrofitClientInstance.getRetrofitInstance().create(GetCountryListService.class);

        Call<CountriesList> call = getCountryListService.getAllCountryList();

        call.enqueue(new Callback<CountriesList>() {
            @Override
            public void onResponse(Call<CountriesList> call, Response<CountriesList> response) {
                countriesList = response.body();
                Log.i(TAG, countriesList.getCountryList().size() + "");


                callCountriesAdapter(countriesList);
            }

            @Override
            public void onFailure(Call<CountriesList> call, Throwable t) {
                Log.i(TAG, t.getMessage());
            }
        });
    }

    @Override
    public void callCountriesAdapter(CountriesList body) {
        myCountryAdapter = new MyCountryAdapter(body.getCountryList());
        recyclerView.setAdapter(myCountryAdapter);
    }

}
