package com.example.activitylifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Intent i=new Intent(MainActivity.this,MainActivity2.class);
        //startActivity(i);
        //finish();
        Log.i("onCreate()","onCreate() method called..");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart()","onStart() method called..");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume()","onResume() method called..");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause()","onPause() method called..");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart()","onRestart() method called..");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop()","onStop() method called..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy()","onDestroy() method called..");
    }
}