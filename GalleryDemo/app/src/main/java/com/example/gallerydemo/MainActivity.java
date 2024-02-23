package com.example.gallerydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgMain;
    Button btnPrevious,btnNext;
    SeekBar seekMusic;
    RatingBar rate;
    int imgArr[]={R.mipmap.i1,R.mipmap.i2,R.mipmap.i3,R.mipmap.i4,R.mipmap.i5,R.mipmap.i6};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMain=findViewById(R.id.imgMain);
        btnNext=findViewById(R.id.btnNext);
        btnPrevious=findViewById(R.id.btnPrevious);
        seekMusic=findViewById(R.id.seekMusic);
        rate=findViewById(R.id.rate);

        rate.setNumStars(5);
        rate.setStepSize(1);
        rate.setRating(3);

        seekMusic.setMax(200);
        seekMusic.setProgress(30);
        seekMusic.incrementProgressBy(5);

        seekMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity.this, "Seekbar touch started..", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity.this, "Seekbar touch stopped..", Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, ""+seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });






        imgMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ImageMainActivity.class);
                intent.putExtra("id",imgArr[i]);
                startActivity(intent);
            }
        });



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i>= imgArr.length)
                    i=0;

                imgMain.setImageResource(imgArr[i]);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                if(i<0)
                    i=imgArr.length-1;
                imgMain.setImageResource(imgArr[i]);
            }
        });
    }
}