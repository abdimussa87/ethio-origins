package com.example.ethioorigins;

public class TourItem {

   private int mImageResource;
   private String mSiteTitile;
   private String mSiteDetail;

    public TourItem(int mImageResource, String mSiteTitile, String mSiteDetail) {
        this.mImageResource = mImageResource;
        this.mSiteTitile = mSiteTitile;
        this.mSiteDetail = mSiteDetail;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmSiteTitile() {
        return mSiteTitile;
    }

    public void setmSiteTitile(String mSiteTitile) {
        this.mSiteTitile = mSiteTitile;
    }

    public String getmSiteDetail() {
        return mSiteDetail;
    }

    public void setmSiteDetail(String mSiteDetail) {
        this.mSiteDetail = mSiteDetail;
    }
}
