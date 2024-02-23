package com.example.gallerydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    GridView grid;
    String arr[]={"A","B","C","D","E","F","G","H","I","J","K","L"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        grid=findViewById(R.id.grid);
        grid.setNumColumns(4);
        ArrayAdapter adapter=new ArrayAdapter(GridActivity.this, android.R.layout.simple_list_item_1,arr);
        grid.setAdapter(adapter);
    }
}