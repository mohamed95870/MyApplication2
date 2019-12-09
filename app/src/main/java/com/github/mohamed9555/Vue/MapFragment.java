package com.github.mohamed9555.Vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.mohamed9555.R;

import java.util.List;

import com.github.mohamed9555.Control.Controller;
import com.github.mohamed9555.Model.Countries;
import retrofitgerrit.OnItemClickListener;

public class MapFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Countries> countriesList;
    private Controller controller;
    private Toolbar toolbar;
    View view;
 //   @Nullable
    @Override

   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    //    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);

        controller = new Controller(this);
        //controller.start();
//        Log.w("DEBUG", countriesList.toString());
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        controller.start();
        //displayCountriesList(countriesList);
    }

    private void setSupportActionBar(View toolbar) {
    }
    public void displayCountriesList(List<Countries> countriesList) {
        this.countriesList = countriesList;
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(countriesList, new OnItemClickListener() {
            @Override
            public void onItemClick(Countries item) {
                intentExtra(item);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }


    public void intentExtra(Countries item){
        Intent intent = new Intent(getContext().getApplicationContext(), Main2Activity.class);
        intent.putExtra("capital",item.getCapital() );
        intent.putExtra("population", item.getPopulation());
        intent.putExtra("region", item.getRegion());

        startActivity(intent);
    }


}