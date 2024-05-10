package com.tarjani.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.tarjani.mediaplayerdemo.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MediaPlayer player;
    boolean isPlay=true;
    int time=1000;
    int songs[]={R.raw.song1,R.raw.song2,R.raw.song3,R.raw.song4,R.raw.song5,R.raw.song6};
    int current=0;
    int cTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        player=MediaPlayer.create(MainActivity.this,songs[0]);
        int total=player.getDuration();
        binding.seekBar.setMax(total);
        Handler h=new Handler();
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                cTime=player.getCurrentPosition();
                binding.seekBar.setProgress(cTime);
                h.postDelayed(this,1000);
            }
        });

        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(isPlay) {
                   player.start();
                   isPlay=false;
                   binding.btnPlay.setText("Pause");
               }
               else{
                   player.pause();
                   isPlay=true;
                   binding.btnPlay.setText("Play");
               }
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current--;
                if(current<0){
                    current=songs.length-1;
                }
                player.reset();
                player=MediaPlayer.create(getApplicationContext(),songs[current]);
                player.start();
                isPlay=false;
            }
        });
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current++;
                if(current>songs.length-1){
                    current=0;
                }
                player.reset();
                player=MediaPlayer.create(getApplicationContext(),songs[current]);
                player.start();
                isPlay=false;

            }
        });
        binding.btnBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentTime=player.getCurrentPosition();
                int newTime=currentTime-time;
                player.seekTo(newTime);
            }
        });
        binding.btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentTime=player.getCurrentPosition();

                int newTime=currentTime+time;
                binding.seekBar.setProgress(newTime);
                player.seekTo(newTime);
            }
        });
/*
        binding.btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });
*/
        binding.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();

                try {
                    player.prepare();
                    isPlay=true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}