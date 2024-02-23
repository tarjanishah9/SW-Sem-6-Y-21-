package com.example.gallerydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ImageMainActivity extends AppCompatActivity {

    ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_main);
        imgShow=findViewById(R.id.imgShow);
        int i=getIntent().getIntExtra("id",0);
        imgShow.setImageResource(i);
    }
}