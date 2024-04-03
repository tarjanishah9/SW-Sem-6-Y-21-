package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databasedemo.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        helper=new DBHelper(getApplicationContext(),"myDatabase",null,1);
        SharedPreferences sharedPreferences=getSharedPreferences("sharedData",MODE_PRIVATE);
        String name=sharedPreferences.getString("FName","");
        String lname=sharedPreferences.getString("LName","");
        String email=sharedPreferences.getString("Email","");
        int id=sharedPreferences.getInt("Id",0);
        binding.txtName.setText("Welcome "+name);
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int row=helper.deleteData(id);
                if(row>0) {
                    Toast.makeText(HomeActivity.this, "Data deleted.", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences=getSharedPreferences("sharedData",MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();

                    editor.remove("FName");
                    editor.remove("LName");
                    editor.remove("Email");
                    editor.remove("Id");
                    editor.clear();
                    editor.commit();
                    Intent i=new Intent(HomeActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.linerUpdate.setVisibility(View.VISIBLE);
                binding.txtFirst.setText(""+name);
                binding.txtLname.setText(""+lname);
                binding.txtEmail.setText(""+email);
                binding.txtEmail.setEnabled(false);

            }
        });
        binding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.txtFirst.getText().toString();
                String lname=binding.txtLname.getText().toString();
                String email=binding.txtEmail.getText().toString();


                Person p=new Person();
                p.setpId(id);
                p.setFname(name);
                p.setLname(lname);
                p.setEmail(email);
                int row=helper.updateData(p);
                if(row>0) {
                    Toast.makeText(HomeActivity.this, "Data updated..", Toast.LENGTH_SHORT).show();
                    binding.linerUpdate.setVisibility(View.GONE);
                }
                else
                    Toast.makeText(HomeActivity.this, "Error..", Toast.LENGTH_SHORT).show();


            }
        });

    }
}