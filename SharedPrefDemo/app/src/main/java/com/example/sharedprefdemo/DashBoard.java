package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {

    TextView txtUser;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        txtUser=findViewById(R.id.txtUser);
        btnLogout=findViewById(R.id.btnLogout);
        SharedPreferences preferences=getSharedPreferences("loginDetails",MODE_PRIVATE);
        String user=preferences.getString("userName","");
        txtUser.setText("Welcome "+user);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=preferences.edit();
                editor.putBoolean("isLogin",false);
                editor.commit();
                Intent i=new Intent(DashBoard.this,LoginActivity.class);
                startActivity(i);

            }
        });
    }
}