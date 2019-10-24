package com.example.ethioorigins;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;

    private ImageView mRestaurantsImageview, mHotelImageview, mTourImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mRestaurantsImageview = findViewById(R.id.restaurants_image_view);
        mHotelImageview = findViewById(R.id.hotel_imageview);
        mTourImageview = findViewById(R.id.tour_imageview);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mRestaurantsImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        mHotelImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        mTourImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });


        Intent intent = getIntent();

        if(intent.hasExtra("username")&& intent.hasExtra("password")) {

            String username = intent.getStringExtra("username");
            String password = intent.getStringExtra("password");
            String uId = mAuth.getCurrentUser().getUid();
            Map<String, String> userMap = new HashMap<>();
            userMap.put("username", username);
            userMap.put("password", password);
            mFirestore.collection("Users").document(uId).set(userMap).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    String error = e.getMessage();
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private void buttonClicked(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.restaurants_image_view:
                intent.setClass(MainActivity.this, Restaurants.class);
                intent.putExtra(Restaurants.RESTAURANT_EXTRA, 0);
                break;
            case R.id.hotel_imageview:
                intent.setClass(MainActivity.this, Hotel.class);
                intent.putExtra(Hotel.HOTEL_EXTRA, 1);
                break;
            case R.id.tour_imageview:
                intent.setClass(MainActivity.this,Tour.class);
                break;

        }
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_acccount_settings) {
            Intent intent = new Intent(MainActivity.this, AccountSettings.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_logout) {
            mAuth.signOut();
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
            finish();

        } else if (id == R.id.nav_hotel) {
            Intent hotelIntent = new Intent(this, Hotel.class);
            hotelIntent.putExtra(Hotel.HOTEL_EXTRA, 1);
            startActivity(hotelIntent);

        } else if (id == R.id.nav_restaurants) {
            Intent restaurantIntent = new Intent(this, Restaurants.class);
            restaurantIntent.putExtra(Restaurants.RESTAURANT_EXTRA, 0);
            startActivity(restaurantIntent);

        } else if (id == R.id.nav_tour) {
            Intent tourIntent = new Intent(this,Tour.class);
            startActivity(tourIntent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_about) {
            Intent aboutIntent = new Intent(this, About.class);
            startActivity(aboutIntent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
