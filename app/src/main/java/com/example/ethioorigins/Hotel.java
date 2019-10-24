package com.example.ethioorigins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Hotel extends AppCompatActivity {

    public static final String HOTEL_EXTRA = "com.example.ethioorigins.MESSAGE";
    ArrayList<HotelItem> mHotelList = new ArrayList<>();
    private RecyclerView mHotelRecyclerView;
    private HotelAdapter mHotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        mHotelRecyclerView = findViewById(R.id.hotel_recycle_view);

        mHotelList.add(new HotelItem(R.drawable.sheraton,"Sheraton","$130","per night on Hotels.com"));
        mHotelList.add(new HotelItem(R.drawable.hilton,"Hilton","$120","per night on Bookings.com"));
        mHotelList.add(new HotelItem(R.drawable.skylight,"SkyLight","$90","per night on Hotels.com"));


        mHotelAdapter = new HotelAdapter(Hotel.this,mHotelList);
        mHotelRecyclerView.setAdapter(mHotelAdapter);
        mHotelRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        int title  = intent.getIntExtra(HOTEL_EXTRA,0);
        setTitle(Utility.TITLES[title]);

    }
}
