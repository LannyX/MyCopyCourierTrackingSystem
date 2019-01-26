package com.rjt.b16couriertrackingsystem.map;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.map.model.Result;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends Fragment {
    List<Result> resultList;
    RecyclerView myrecyclerView;
    NearbyAdapter mynearbyAdapter;



    public NearbyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        myrecyclerView = view.findViewById(R.id.nearbyListRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        myrecyclerView.setLayoutManager(linearLayoutManager);
        myrecyclerView.setItemAnimator(new DefaultItemAnimator());

        Bundle b = getArguments();
        resultList = (List<Result>) b.getSerializable("unique");

        mynearbyAdapter = new NearbyAdapter(resultList);
        myrecyclerView.setAdapter(mynearbyAdapter);

        return view;
    }

}
