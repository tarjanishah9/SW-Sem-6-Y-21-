package com.example.customlistdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listData;
    ArrayList<String> mainArr=new ArrayList<>(),subArr=new ArrayList<>();
    ArrayList<Integer> imgArr=new ArrayList<>();
    String mainArr1[]={"Ahmedabad","Surat","Baroda","Bharuch","Rajkot"};
    String subArr1[]={"Small","Smaller","Smallest","Big","Bigger"};
    int imgArr1[]={R.mipmap.i1,R.mipmap.i2,R.mipmap.i3,R.mipmap.i4,R.mipmap.i5};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listData=findViewById(R.id.listData);
        for(int i=0;i<mainArr1.length;i++) {
            mainArr.add(mainArr1[i]);
            subArr.add(subArr1[i]);
            imgArr.add(imgArr1[i]);

        }
        CustomAdapter adapter=new CustomAdapter(MainActivity.this,imgArr,mainArr,subArr);
        listData.setAdapter(adapter);
        listData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int j, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete data");
                builder.setIcon(R.mipmap.delete);
                builder.setMessage("Are you sure tou want to delete data?");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mainArr.remove(j);
                        subArr.remove(j);
                        imgArr.remove(j);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Data deleted..", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });


                AlertDialog dialog=builder.create();
                dialog.show();

                return false;
            }
        });



    }
}