package com.example.ethioorigins;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailRestaurants extends AppCompatActivity {
    private static final String TAG = "DetailRestaurants";
    public static final String DETAIL_RESTAURANTS_EXTRA ="com.example.ethioorigins.DETAIL";
    private ImageView mDetailRestaurantTitleImageview,mRestaurnatDetailFoodImagev1,mRestaurnatDetailFoodImagev2,mRestaurnatDetailFoodImagev3;
    private TextView mContents_tv1,mContents_tv2,mContents_tv3,mFoodPriceTv1,mFoodPriceTv2,mFoodPriceTv3,mFoodRatingTv1,mFoodRatingTv2,mFoodRatingTv3,mDetailRestaurantsTitleTv,mRestaurantDetailFoodTitle1,mRestaurantDetailFoodTitle2,mRestaurantDetailFoodTitle3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_restaurants);




        mDetailRestaurantTitleImageview = findViewById(R.id.detail_restaurant_title_iv);
        mDetailRestaurantsTitleTv = findViewById(R.id.detail_restaurants_title_tv);
        mRestaurnatDetailFoodImagev1 = findViewById(R.id.restaurnat_detail_food_iv1);
        mRestaurnatDetailFoodImagev2 = findViewById(R.id.restaurnat_detail_food_iv2);
        mRestaurnatDetailFoodImagev3 = findViewById(R.id.restaurnat_detail_food_iv3);
        mRestaurantDetailFoodTitle1 = findViewById(R.id.restaurant_detail_food_title1);
        mRestaurantDetailFoodTitle2 = findViewById(R.id.restaurant_detail_food_title2);
        mRestaurantDetailFoodTitle3 = findViewById(R.id.restaurant_detail_food_title3);
        mContents_tv1 = findViewById(R.id.contents_tv1);
        mContents_tv2 = findViewById(R.id.contents_tv2);
        mContents_tv3 = findViewById(R.id.contents_tv3);
        mFoodPriceTv1 = findViewById(R.id.food_price_tv1);
        mFoodPriceTv2 = findViewById(R.id.food_price_tv2);
        mFoodPriceTv3 = findViewById(R.id.food_price_tv3);
        mFoodRatingTv1 = findViewById(R.id.food_rating_tv1);
        mFoodRatingTv2 = findViewById(R.id.food_rating_tv2);
        mFoodRatingTv3 = findViewById(R.id.food_rating_tv3);

        Intent intent = getIntent();
        final int result = intent.getIntExtra(DETAIL_RESTAURANTS_EXTRA,0);
        if (result== 2){
            mDetailRestaurantTitleImageview.setImageResource(Utility.RESTAURANT_IMAGES[result]);
            mDetailRestaurantsTitleTv.setText(Utility.RESTAURANT_NAMES[result]);
            mRestaurnatDetailFoodImagev1.setImageResource(Utility.CHICKEN_HUT_FOOD_IMAGES[0]);
            mRestaurnatDetailFoodImagev2.setImageResource(Utility.CHICKEN_HUT_FOOD_IMAGES[1]);
            mRestaurnatDetailFoodImagev3.setImageResource(Utility.CHICKEN_HUT_FOOD_IMAGES[2]);
            setTitle(Utility.RESTAURANT_NAMES[result]);
            mRestaurantDetailFoodTitle1.setText(Utility.CHICKEN_HUT_FOOD_Types[0]);
            mRestaurantDetailFoodTitle2.setText(Utility.CHICKEN_HUT_FOOD_Types[1]);
            mRestaurantDetailFoodTitle3.setText(Utility.CHICKEN_HUT_FOOD_Types[2]);

            mContents_tv1.setText(Utility.CHICKEN_HUT_FOOD_CONTENTS[0]);
            mContents_tv2.setText(Utility.CHICKEN_HUT_FOOD_CONTENTS[1]);
            mContents_tv3.setText(Utility.CHICKEN_HUT_FOOD_CONTENTS[2]);

            mFoodPriceTv1.setText(Utility.CHICKEN_HUT_FOOD_PRICE[0]);
            mFoodPriceTv2.setText(Utility.CHICKEN_HUT_FOOD_PRICE[1]);
            mFoodPriceTv3.setText(Utility.CHICKEN_HUT_FOOD_PRICE[2]);

            mFoodRatingTv1.setText(Utility.CHICKEN_HUT_FOOD_RATING[0]);
            mFoodRatingTv2.setText(Utility.CHICKEN_HUT_FOOD_RATING[1]);
            mFoodRatingTv3.setText(Utility.CHICKEN_HUT_FOOD_RATING[2]);


        }
        else if(result == 1) {


            setTitle(Utility.RESTAURANT_NAMES[result]);
            mDetailRestaurantTitleImageview.setImageResource(Utility.RESTAURANT_IMAGES[result]);
            mDetailRestaurantsTitleTv.setText(Utility.RESTAURANT_NAMES[result]);
            mRestaurnatDetailFoodImagev1.setImageResource(Utility.PARKDALE_FOOD_IMAGES[0]);
            mRestaurnatDetailFoodImagev2.setImageResource(Utility.PARKDALE_FOOD_IMAGES[1]);
            mRestaurnatDetailFoodImagev3.setImageResource(Utility.PARKDALE_FOOD_IMAGES[2]);
            mRestaurantDetailFoodTitle1.setText(Utility.FOOD_TYPES[0]);
            mRestaurantDetailFoodTitle2.setText(Utility.FOOD_TYPES[1]);
            mRestaurantDetailFoodTitle3.setText(Utility.FOOD_TYPES[2]);

            mContents_tv1.setText(Utility.FOOD_CONTENTS[0]);
            mContents_tv2.setText(Utility.FOOD_CONTENTS[1]);
            mContents_tv3.setText(Utility.FOOD_CONTENTS[2]);

            mFoodPriceTv1.setText(Utility.FOOD_PRICE[0]);
            mFoodPriceTv2.setText(Utility.FOOD_PRICE[1]);
            mFoodPriceTv3.setText(Utility.FOOD_PRICE[2]);

            mFoodRatingTv1.setText(Utility.FOOD_RATING[0]);
            mFoodRatingTv2.setText(Utility.FOOD_RATING[1]);
            mFoodRatingTv3.setText(Utility.FOOD_RATING[2]);

        }

        else{
            setTitle(Utility.RESTAURANT_NAMES[0]);
            mDetailRestaurantTitleImageview.setImageResource(Utility.RESTAURANT_IMAGES[result]);
            mDetailRestaurantsTitleTv.setText(Utility.RESTAURANT_NAMES[result]);
            mRestaurnatDetailFoodImagev1.setImageResource(Utility.BELLAVIEW_FOOD_IMAGES[0]);
            mRestaurnatDetailFoodImagev2.setImageResource(Utility.BELLAVIEW_FOOD_IMAGES[1]);
            mRestaurnatDetailFoodImagev3.setImageResource(Utility.BELLAVIEW_FOOD_IMAGES[2]);

            mRestaurantDetailFoodTitle1.setText(Utility.CHICKEN_HUT_FOOD_Types[0]);
            mRestaurantDetailFoodTitle2.setText(Utility.CHICKEN_HUT_FOOD_Types[1]);
            mRestaurantDetailFoodTitle3.setText(Utility.CHICKEN_HUT_FOOD_Types[2]);

            mContents_tv1.setText(Utility.CHICKEN_HUT_FOOD_CONTENTS[0]);
            mContents_tv2.setText(Utility.CHICKEN_HUT_FOOD_CONTENTS[1]);
            mContents_tv3.setText(Utility.CHICKEN_HUT_FOOD_CONTENTS[2]);

            mFoodPriceTv1.setText(Utility.CHICKEN_HUT_FOOD_PRICE[0]);
            mFoodPriceTv2.setText(Utility.CHICKEN_HUT_FOOD_PRICE[1]);
            mFoodPriceTv3.setText(Utility.CHICKEN_HUT_FOOD_PRICE[2]);

            mFoodRatingTv1.setText(Utility.CHICKEN_HUT_FOOD_RATING[0]);
            mFoodRatingTv2.setText(Utility.CHICKEN_HUT_FOOD_RATING[1]);
            mFoodRatingTv3.setText(Utility.CHICKEN_HUT_FOOD_RATING[2]);


        }
        FloatingActionButton locateBtn = findViewById(R.id.fab);
        locateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationName = getString(Utility.RESTAURANT_NAMES[result]);
                Log.d(TAG, "onClick: "+ locationName);
                Uri uri = Uri.parse("google.navigation:q=" + locationName);
                Intent locateIntent = new Intent(Intent.ACTION_VIEW,uri);
                if (locateIntent.resolveActivity(getPackageManager()) != null) {

                    startActivity(locateIntent);
                }
            }
        });

    }

}
