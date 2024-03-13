package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText edEmail,edPass,edName;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edEmail=findViewById(R.id.edEmail);
        edPass=findViewById(R.id.edPass);
        edName=findViewById(R.id.edName);
        btnRegister=findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edName.getText().toString();
                String email=edEmail.getText().toString();
                String pass=edPass.getText().toString();
                SharedPreferences preferences=getSharedPreferences("loginDetails",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("userName",name);
                editor.putBoolean("isLogin",true);
                editor.commit();
                Intent i=new Intent(RegisterActivity.this,DashBoard.class);
                startActivity(i);

            }
        });
    }
}