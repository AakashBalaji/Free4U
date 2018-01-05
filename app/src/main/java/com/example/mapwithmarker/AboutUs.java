package com.example.mapwithmarker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class AboutUs extends AppCompatActivity {

    public Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        button4 = (Button) findViewById(R.id.Button);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent registerBtn = new Intent(AboutUs.this, MapsMarkerActivity.class);
                    startActivity(registerBtn);
                }
            }

    });
    }






    public void onButtonClick(View v) {
        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.free4u);
        videoview.setVideoURI(uri);
        videoview.start();


    }
}










