package com.example.ethioorigins;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class HotelDetailActivity extends AppCompatActivity {

    private ImageView mHotelDetailImageView;
    private TextView mHotelDetailHotelName, mDealsDetailTv1, mDealsDetailTv2, mDealsDetailTv1MoneyTv1, mDealsDetailTv2MoneyTv2;
    private Button mBookBtn, mPostBtn;
    private EditText mGiveReviewEditText;
    private FloatingActionButton mNavigateBtn;
    private int position;
    private JustifiedTextView mHotelDescription,mGuestReviewDetailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);

        mHotelDetailImageView = findViewById(R.id.hotel_detail_image_view);
        mHotelDetailHotelName = findViewById(R.id.hotel_detail_hotel_name);
        mHotelDescription = findViewById(R.id.hotel_description);
        mDealsDetailTv1 = findViewById(R.id.deals_detail_tv1);
        mDealsDetailTv2 = findViewById(R.id.deals_detail_tv2);
        mDealsDetailTv1MoneyTv1 = findViewById(R.id.deals_detail_tv1_money_tv1);
        mDealsDetailTv2MoneyTv2 = findViewById(R.id.deals_detail_tv2_money_tv2);
        mGuestReviewDetailTv = findViewById(R.id.guest_review_detail_tv);
        mGiveReviewEditText = findViewById(R.id.give_review_edit_text);

        mBookBtn = findViewById(R.id.book_btn);
        mPostBtn = findViewById(R.id.post_btn);

        mNavigateBtn = findViewById(R.id.navigate_btn);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        int hotelImage = intent.getIntExtra("hotel_image", 0);
        String hotelName = intent.getStringExtra("hotel_name");
        String price = intent.getStringExtra("hotel_price");

        mHotelDetailImageView.setImageResource(hotelImage);
        mHotelDetailHotelName.setText(hotelName);
        mHotelDescription.setText(Utility.HOTEL_DESCRIPTION[position]);
        mDealsDetailTv2MoneyTv2.setText(Utility.HOTEL_PRICE[position]);
        mGuestReviewDetailTv.setText(Utility.HOTEL_REVIEW[position]);
        mDealsDetailTv1MoneyTv1.setText(price);

        setTitle(Utility.HOTEL_NAME[position]);

        mNavigateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        mPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        mBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
    }

    private void buttonClicked(View v) {
        switch (v.getId()) {
            case R.id.navigate_btn:
                Uri uri = Uri.parse("google.navigation:q=" + getSupportActionBar().getTitle().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.post_btn:
                String review = mGiveReviewEditText.getText().toString();
                String previousReview =  mGuestReviewDetailTv.getText().toString();
                mGuestReviewDetailTv.setText(previousReview + "\n\n" + review);
                break;

            case R.id.book_btn:
                DialogFragment dateFragment = new DatePickerFragment();
                dateFragment.show(getSupportFragmentManager(), "DatePicker");
                break;
        }
    }


    public void processDatePicked(int year, int month, int day) {

        String year_string = Integer.toString(year);
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);

        String dateMessage = day_string + "/" + month_string + "/" + year_string;

        Toast.makeText(this, "You have booked your room at the date: " + dateMessage + ". We wish you have a great stay at our hotel.", Toast.LENGTH_LONG).show();
    }
}
