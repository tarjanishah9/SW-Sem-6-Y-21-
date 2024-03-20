package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databasedemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper helper=new DBHelper(getApplicationContext(),"myDatabase",null,1);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=binding.edFirstName.getText().toString();
                String lname=binding.edLastName.getText().toString();
                String email=binding.edEmail.getText().toString();
                String pass=binding.edPass.getText().toString();
                long row=helper.addData(fname,lname,email,pass);
                if(row>0)
                    Toast.makeText(MainActivity.this, "Data saved..", Toast.LENGTH_SHORT).show();

            }
        });


    }
}