package com.example.firstapplication1402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RegisterActivity extends AppCompatActivity {

    EditText edUser;
    Button btnSubmit,btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUser=findViewById(R.id.edUserName);
        btnSubmit=findViewById(R.id.btnSubmit);
        btnGet=findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=getSharedPreferences("myFile",MODE_PRIVATE);
                String u=preferences.getString("user","");
                Toast.makeText(RegisterActivity.this, "User Name :"+u, Toast.LENGTH_SHORT).show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Set<String> aa= new HashSet<>();
                aa.add("AA");
                aa.add("BB");


                String user=edUser.getText().toString();
                SharedPreferences preferences=getSharedPreferences("myFile",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("user",user);
                editor.putStringSet("arr", aa);

                editor.commit();
            }
        });
    }
}