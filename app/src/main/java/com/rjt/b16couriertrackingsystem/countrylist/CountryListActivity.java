package com.rjt.b16couriertrackingsystem.countrylist;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.countrylist.model.CountriesList;
import com.rjt.b16couriertrackingsystem.countrylist.network.GetCountryListService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryListActivity extends AppCompatActivity {
    final String TAG = CountryListActivity.class.getSimpleName();
    GetCountryListService getCountryListService;
    private SearchView searchView;
    RecyclerView recyclerView;
    MyCountryListAdapter myCountryListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        recyclerView = findViewById(R.id.countryListRecyclerView);

        getCountryListService = RetrofitClientInstance.getRetrofitInstance().create(GetCountryListService.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getCountryList();

    }

    private void getCountryList() {
        Call<CountriesList> call = getCountryListService.getAllCountryList();

        call.enqueue(new Callback<CountriesList>() {
            @Override
            public void onResponse(Call<CountriesList> call, Response<CountriesList> response) {
                CountriesList countriesList = response.body();
                Log.i(TAG, countriesList.getCountryList().size() + "");

                callCountriesAdapter(countriesList);
            }

            @Override
            public void onFailure(Call<CountriesList> call, Throwable t) {
                Log.i(TAG, t.getMessage());
            }
        });
    }

    private void callCountriesAdapter(CountriesList body) {
        myCountryListAdapter = new MyCountryListAdapter(body);
        recyclerView.setAdapter(myCountryListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.country_search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // filter recycler view when query submitted
                myCountryListAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                Log.i("xxx", query);
                myCountryListAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
