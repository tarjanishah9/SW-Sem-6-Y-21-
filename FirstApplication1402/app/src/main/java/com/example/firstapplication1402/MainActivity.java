package com.example.firstapplication1402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText edName;
    TextView txtName;
    CheckBox chMusic,chDance,chCricket;
    RadioButton rbMale,rbFemale;
    RadioGroup rgGender;
    AutoCompleteTextView autoCity;
    Spinner spCity;
    Switch swWifi;
    ToggleButton tbBluetooth;
    String city[]={"Ahmedabad","Baroda","Surat","Valsad","Rajkot","Ambaji","Veraval","Amreli","Bhuj","Bardoli"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit=findViewById(R.id.btnSubmit);
        edName=findViewById(R.id.edName);
        autoCity=findViewById(R.id.autoCity);
        spCity=findViewById(R.id.spCity);
        txtName=findViewById(R.id.txtName);
        chMusic=findViewById(R.id.chMusic);
        chDance=findViewById(R.id.chDance);
        chCricket=findViewById(R.id.chCricket);
        rgGender=findViewById(R.id.rgGender);
        rbFemale=findViewById(R.id.rbFemale);
        swWifi= findViewById(R.id.swWifi);
        tbBluetooth=findViewById(R.id.tbBluetooth);
        tbBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    Toast.makeText(MainActivity.this, "Bluetooth  on..", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Blueto.oth off..", Toast.LENGTH_SHORT).show();
            }
        });

        swWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    Toast.makeText(MainActivity.this, "Switch selected..", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Switch not selected..", Toast.LENGTH_SHORT).show();
            }
        });

        rbMale=findViewById(R.id.rbMale);
        autoCity.setThreshold(1);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,city);
        autoCity.setAdapter(adapter);



        spCity.setAdapter(adapter);
        spCity.setSelection(3);
        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "City :"+city[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbMale)
                    Toast.makeText(MainActivity.this, "Male selected..", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Female selected..", Toast.LENGTH_SHORT).show();
            }
        });
       /* rbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    Toast.makeText(MainActivity.this, "Male selected..", Toast.LENGTH_SHORT).show();
            }
        });
        rbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    Toast.makeText(MainActivity.this, "Female selected..", Toast.LENGTH_SHORT).show();
            }
        });*/
        chMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Music checked..", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Music unchecked..", Toast.LENGTH_SHORT).show();
                }

            }
        });
        chDance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Dance checked..", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Dance unchecked..", Toast.LENGTH_SHORT).show();
                }

            }
        });
        chCricket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Cricket checked..", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Cricket unchecked..", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  String hobby="";
                String name=edName.getText().toString();


                if(chCricket.isChecked())
                    hobby+="Cricket Checked.";
                if(chMusic.isChecked())
                    hobby+="Music Checked.";
                if(chDance.isChecked())
                    hobby+="Dance checked.";


                txtName.setText("Hello "+name+"\nHobby: "+hobby);
                Log.i("Name","Your Name is :"+name);
                Toast.makeText(MainActivity.this, "Your Name is :"+name, Toast.LENGTH_SHORT).show();*/
                String name=edName.getText().toString();
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("First",name);
                startActivity(i);
















            }
        });
    }
}