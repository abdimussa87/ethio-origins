package com.example.ethioorigins;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class About extends AppCompatActivity {
    private ImageButton mFacebookBtn;
    private ImageButton mTelegramBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mFacebookBtn = findViewById(R.id.facbook_btn);
        mTelegramBtn = findViewById(R.id.telegram_btn);

        mFacebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri web = Uri.parse("http://facebook.com/abdi.mussa.39");
                Intent intent = new Intent(Intent.ACTION_VIEW,web);
                if(intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }
            }
        });

        mTelegramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri telegram = Uri.parse("https://t.me/abdimussa93");
                Intent intent = new Intent(Intent.ACTION_VIEW,telegram);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }
}
