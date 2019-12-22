package com.github.mohamed9555.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.github.mohamed9555.R;

import java.util.List;

import com.github.mohamed9555.Model.Countries;
import retrofitgerrit.OnItemClickListener;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Countries> countriesList;
    private Toolbar toolbar;

    private MessageFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       recyclerView = findViewById(R.id.my_recycler_view);

    }

    public void displayCountriesList(List<Countries> countriesList) {
        this.countriesList = countriesList;
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
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
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        intent.putExtra("capital",item.getCapital() );
        intent.putExtra("population", item.getPopulation());
        intent.putExtra("region", item.getRegion());

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}