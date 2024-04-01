package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.databasedemo.databinding.ActivityLoginBinding;
import com.example.databasedemo.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        helper=new DBHelper(getApplicationContext(),"myDatabase",null,1);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.txtEmail.getText().toString();
                String pass=binding.txtPassowrd.getText().toString();

                if(TextUtils.isEmpty(email))
                    binding.txtEmail.setError("Email is blank");
               else if(TextUtils.isEmpty(pass))
                    binding.txtPassowrd.setError("Password is blank");
               else
                {
                    Person p=new Person(email,pass);
                    Person person=helper.checkUser(p);

                    if(person!=null){
                        SharedPreferences preferences=getSharedPreferences("sharedData",MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferences.edit();
                        editor.putInt("Id",person.getpId());
                        editor.putString("FName",person.getFname());
                        editor.putString("Email",person.getEmail());
                        editor.commit();
                        Intent i=new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(i);
                        
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "No user found..", Toast.LENGTH_SHORT).show();
                    }
                        

                }



//                if(email.equalsIgnoreCase(""))
//                    Toast.makeText(LoginActivity.this, "Email is blank..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}