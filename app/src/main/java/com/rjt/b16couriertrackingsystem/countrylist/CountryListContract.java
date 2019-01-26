package com.rjt.b16couriertrackingsystem.countrylist;

import com.rjt.b16couriertrackingsystem.countrylist.model.CountriesList;

public interface CountryListContract {

    interface CountryListView{

    }

    interface CountryListPresenter{
        void getCountryList();

        void callCountriesAdapter(CountriesList body);
    }
}
