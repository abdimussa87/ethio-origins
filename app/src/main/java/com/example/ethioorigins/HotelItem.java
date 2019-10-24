package com.example.ethioorigins;

public class HotelItem {

    private int mImageResource;
    private String mHotelName;
    private String mMoney;
    private String mPerNightOn;

    public HotelItem(int mImageResource, String mHotelName, String mMoney, String mPerNightOn) {
        this.mImageResource = mImageResource;
        this.mHotelName = mHotelName;
        this.mMoney = mMoney;
        this.mPerNightOn = mPerNightOn;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmHotelName() {
        return mHotelName;
    }

    public void setmHotelName(String mHotelName) {
        this.mHotelName = mHotelName;
    }

    public String getmMoney() {
        return mMoney;
    }

    public void setmMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    public String getmPerNightOn() {
        return mPerNightOn;
    }

    public void setmPerNightOn(String mPerNightOn) {
        this.mPerNightOn = mPerNightOn;
    }
}
