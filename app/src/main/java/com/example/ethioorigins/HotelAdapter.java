package com.example.ethioorigins;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    Context mContext;
    ArrayList<HotelItem> mHotelList = new ArrayList<>();

    public HotelAdapter(Context mContext, ArrayList<HotelItem> mHotelList) {
        this.mContext = mContext;
        this.mHotelList = mHotelList;
    }

    class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mHotelImageView;
        private TextView mHotelNameTv;
        private TextView mMoneyTv;
        private TextView mPerNightOnTv;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            mHotelImageView = itemView.findViewById(R.id.hote_hotel_iv);
            mHotelNameTv = itemView.findViewById(R.id.hotel_name_tv);
            mMoneyTv = itemView.findViewById(R.id.money_tv);
            mPerNightOnTv = itemView.findViewById(R.id.per_night_on_tv);
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View v) {

            int position = getLayoutPosition();
            HotelItem currentItem = mHotelList.get(position);

            int hotelImage = currentItem.getmImageResource();
            String hotelName = currentItem.getmHotelName();
            String price = currentItem.getmMoney();

            Intent hotelDetailIntent = new Intent(mContext,HotelDetailActivity.class);
            hotelDetailIntent.putExtra("position",position);
            hotelDetailIntent.putExtra("hotel_image",hotelImage);
            hotelDetailIntent.putExtra("hotel_name",hotelName);
            hotelDetailIntent.putExtra("hotel_price",price);
            mContext.startActivity(hotelDetailIntent);

        }
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.hotel_item,viewGroup,false);
       return new HotelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int position) {
        HotelItem currentItem = mHotelList.get(position);
        hotelViewHolder.mHotelImageView.setImageResource(currentItem.getmImageResource());
        hotelViewHolder.mHotelNameTv.setText(currentItem.getmHotelName());
        hotelViewHolder.mMoneyTv.setText(currentItem.getmMoney());
        hotelViewHolder.mPerNightOnTv.setText(currentItem.getmPerNightOn());
    }

    @Override
    public int getItemCount() {
        return mHotelList.size();
    }
}
