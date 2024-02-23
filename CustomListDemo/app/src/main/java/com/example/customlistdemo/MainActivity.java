package com.example.customlistdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listData;
    String mainArr[]={"Ahmedabad","Surat","Baroda","Bharuch","Rajkot"};
    String subArr[]={"Small","Smaller","Smallest","Big","Bigger"};
    int imgArr[]={R.mipmap.i1,R.mipmap.i2,R.mipmap.i3,R.mipmap.i4,R.mipmap.i5};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listData=findViewById(R.id.listData);
        CustomAdapter adapter=new CustomAdapter(MainActivity.this,imgArr,mainArr,subArr);
        listData.setAdapter(adapter);



    }
}