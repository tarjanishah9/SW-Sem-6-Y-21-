package com.example.firstapplication1402;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtName=findViewById(R.id.txtName);
        String n=getIntent().getStringExtra("First");
        txtName.setText("Welcome "+n);


    }
}