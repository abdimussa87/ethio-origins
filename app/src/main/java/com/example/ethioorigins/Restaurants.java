package com.example.ethioorigins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;


public class Restaurants extends AppCompatActivity {
    public static final String RESTAURANT_EXTRA = "com.example.ethioorigins.MESSAGE";
    private CircleImageView mBellaviewImageview, mParkdaleImageView;
    private Button mCheckOutBellaviewButton, mCheckoutParkdaleBtn,mCheckOutChickenHut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        mBellaviewImageview = findViewById(R.id.bellaview_iv);
        mParkdaleImageView = findViewById(R.id.parkdale_iv);
        mCheckOutBellaviewButton = findViewById(R.id.checkout_bellaview_btn);
        mCheckoutParkdaleBtn = findViewById(R.id.checkout_parkdale_btn);
        mCheckOutChickenHut  = findViewById(R.id.checkout_chicken_hut_btn);

        Intent intent = getIntent();
        int result = intent.getIntExtra(RESTAURANT_EXTRA, 0);
        String title = getString(Utility.TITLES[result]);
        setTitle(title);

        mCheckOutBellaviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        mCheckoutParkdaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        mCheckOutChickenHut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });


    }

    private void buttonClicked(View v) {
        Intent intent = new Intent();
        intent.setClass(Restaurants.this, DetailRestaurants.class);
        switch (v.getId()) {
            case R.id.checkout_bellaview_btn:

                intent.putExtra(DetailRestaurants.DETAIL_RESTAURANTS_EXTRA, 0);
                break;
            case R.id.checkout_parkdale_btn:
                intent.putExtra(DetailRestaurants.DETAIL_RESTAURANTS_EXTRA, 1);
                break;
            case R.id.checkout_chicken_hut_btn:
                intent.putExtra(DetailRestaurants.DETAIL_RESTAURANTS_EXTRA,2);
                break;
        }

        startActivity(intent);
    }
}
