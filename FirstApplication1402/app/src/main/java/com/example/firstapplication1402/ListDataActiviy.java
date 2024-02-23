package com.example.firstapplication1402;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class ListDataActiviy extends AppCompatActivity {
    ListView listData;
    String arr[]={"A","B","C","D","E","F","G","H","I","J","K","L"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_activiy);
        listData=findViewById(R.id.listData);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(ListDataActiviy.this,
                android.R.layout.simple_list_item_1,arr);
        listData.setAdapter(adapter);

        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListDataActiviy.this, arr[i]+ " clicked..", Toast.LENGTH_SHORT).show();

            }
        });
        listData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListDataActiviy.this, "Long clicked..", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}