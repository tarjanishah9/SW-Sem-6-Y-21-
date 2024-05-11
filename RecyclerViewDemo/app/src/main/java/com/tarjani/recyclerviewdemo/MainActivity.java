package com.tarjani.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String country[]={"Afghanistan","Australia","Bangladesh","Bhutan","Germany","India"};
    int flag[]={R.mipmap.af,R.mipmap.au,R.mipmap.bg,R.mipmap.bh,R.mipmap.gr,R.mipmap.in1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        CustomAdapter adapter=new CustomAdapter(MainActivity.this,country,flag);
        //LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
       GridLayoutManager manager=new GridLayoutManager(getApplicationContext(),2);
       // StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}