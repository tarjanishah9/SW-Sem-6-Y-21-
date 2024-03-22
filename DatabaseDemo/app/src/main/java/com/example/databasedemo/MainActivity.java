package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.databasedemo.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper helper=new DBHelper(getApplicationContext(),"myDatabase",null,1);

        List<Person> personList=helper.getData();
        for (int i = 0; i <personList.size() ; i++) {
            Log.i("First Name "+i,personList.get(i).getFname());
            Log.i("Last Name "+i,personList.get(i).getLname());
            Log.i("Email "+i,personList.get(i).getEmail());
            Log.i("Password "+i,personList.get(i).getPass());
        }
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname=binding.edFirstName.getText().toString();
                String lname=binding.edLastName.getText().toString();
                String email=binding.edEmail.getText().toString();
                String pass=binding.edPass.getText().toString();
                Person p=new Person(fname,lname,email,pass);
                long row=helper.addData(p);
                if(row>0)
                    Toast.makeText(MainActivity.this, "Data saved..", Toast.LENGTH_SHORT).show();

            }
        });


    }
}