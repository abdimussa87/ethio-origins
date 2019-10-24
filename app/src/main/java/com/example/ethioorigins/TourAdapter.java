package com.example.ethioorigins;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import java.util.ArrayList;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    private Context mContext;
    private ArrayList<TourItem> mTourList = new ArrayList<>();

    public TourAdapter(Context context, ArrayList<TourItem> mTourList) {
        this.mContext = context;
        this.mTourList = mTourList;
    }

    class TourViewHolder extends RecyclerView.ViewHolder{

        private ImageView siteImageView;
        private TextView siteNameTextView;
        private JustifiedTextView siteDetailTextView;
        public TourViewHolder(@NonNull View itemView) {
            super(itemView);

            siteImageView = itemView.findViewById(R.id.site_image_view);
            siteNameTextView = itemView.findViewById(R.id.site_title_tv);
            siteDetailTextView = itemView.findViewById(R.id.site_detail);

        }
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.tour_item,viewGroup,false);
        return new TourViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder tourViewHolder, int position) {

        TourItem currentItem = mTourList.get(position);
        tourViewHolder.siteImageView.setImageResource(currentItem.getmImageResource());
        tourViewHolder.siteNameTextView.setText(currentItem.getmSiteTitile());
        tourViewHolder.siteDetailTextView.setText(currentItem.getmSiteDetail());
    }

    @Override
    public int getItemCount() {
        return mTourList.size();
    }
}
