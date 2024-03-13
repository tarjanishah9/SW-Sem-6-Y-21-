package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText edEmail,edPass;
    Button btnSubmit;
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edEmail=findViewById(R.id.edEmail);
        edPass=findViewById(R.id.edPass);
        btnSubmit=findViewById(R.id.btnLogin);
        txtRegister=findViewById(R.id.txtRegister);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edEmail.getText().toString();
                String pass=edPass.getText().toString();
                SharedPreferences preferences=getSharedPreferences("loginDetails",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();

                editor.putBoolean("isLogin",true);
                editor.commit();


            }
        });
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);

            }
        });
    }
}