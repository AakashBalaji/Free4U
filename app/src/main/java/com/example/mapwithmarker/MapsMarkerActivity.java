package com.example.mapwithmarker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */

public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback {
    public Button button6;
    public Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        button6 = (Button) findViewById(R.id.button);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent ABoutBtn = new Intent(MapsMarkerActivity.this, MainActivity.class);
                    startActivity(ABoutBtn);
                }
            }
        });


        button7 = (Button)

                findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                {
                    Intent SearchBtn = new Intent(MapsMarkerActivity.this, Main2Activity.class);
                    startActivity(SearchBtn);
                }
            }

        });
    }


        /**
         * Manipulates the map when it's available.
         * The API invokes this callback when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user receives a prompt to install
         * Play services inside the SupportMapFragment. The API invokes this method after the user has
         * installed Google Play services and returned to the app.
         */

        public void onMapReady (GoogleMap googleMap){
            LatLng sfMusic = new LatLng(37.7749, -122.4194);
            googleMap.addMarker(new MarkerOptions().position(sfMusic)
                    .title("SF Music Fest"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sfMusic, 13));
            LatLng sfFood = new LatLng(37.7821, -122.4194);
            googleMap.addMarker(new MarkerOptions().position(sfFood)
                    .title("SF Food Fest"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sfFood, 13));
            LatLng sfClothes = new LatLng(37.7749, -122.4220);
            googleMap.addMarker(new MarkerOptions().position(sfClothes)
                    .title("SF Clothes Fest"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sfClothes, 13));

        }
    }

