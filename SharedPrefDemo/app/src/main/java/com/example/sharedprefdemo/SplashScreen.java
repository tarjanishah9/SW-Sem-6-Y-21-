package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences=getSharedPreferences("loginDetails",MODE_PRIVATE);
                boolean isLogin=preferences.getBoolean("isLogin",false);
                Intent intent;
                if(isLogin)
                    intent=new Intent(SplashScreen.this,DashBoard.class);
                else
                    intent=new Intent(SplashScreen.this,LoginActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}