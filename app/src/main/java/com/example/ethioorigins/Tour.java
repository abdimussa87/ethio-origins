package com.example.ethioorigins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Tour extends AppCompatActivity {

    private RecyclerView mTourRecyclerView;
    ArrayList<TourItem> mTourList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        setTitle("Tour");
        mTourRecyclerView = findViewById(R.id.tour_recycle_view);

        mTourList.add(new TourItem(R.drawable.tiya, getString(R.string.tiya), getString(R.string.tiya_detail)));
        mTourList.add(new TourItem(R.drawable.axum,getString(R.string.axum),getString(R.string.axum_detail)));
        mTourList.add(new TourItem(R.drawable.gondar_fasiledes,getString(R.string.fasiledes),getString(R.string.fasiledes_detail)));

        TourAdapter adapter = new TourAdapter(Tour.this,mTourList);
        mTourRecyclerView.setAdapter(adapter);
        mTourRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
