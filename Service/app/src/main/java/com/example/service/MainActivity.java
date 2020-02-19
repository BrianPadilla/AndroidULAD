package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MusicStoppedListener {

    ImageView imvPlay;
    String audiolink = "https://open.spotify.com/track/4Q25vG7aYkY2LcgelslHEY?si=DfJey-P5TIK3z4NBo-e3KA";
    boolean musicPlaying = false;
    Intent serviceintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imvPlay = findViewById(R.id.imvPlay);
        imvPlay.setBackgroundResource(R.drawable.as);
        ApplicationClass.context = MainActivity.this;

        serviceintent = new Intent(this,MyPlayService.class);


        imvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(!musicPlaying){
                        playAudio();
                        imvPlay.setImageResource(R.drawable.riel);
                        musicPlaying = true;
                    }

                    else{
                        stopPlayService();
                        imvPlay.setImageResource(R.drawable.as);
                    }
            }
        });
    }

    private void playAudio() {

        serviceintent.putExtra("AudioLink",audiolink);

        try{
            startService(serviceintent);
        }

        catch (SecurityException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void stopPlayService(){
        try{
            stopService(serviceintent);
        }

        catch (SecurityException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMusicStopped() {
        imvPlay.setImageResource(R.drawable.as);
        musicPlaying = false;
    }
}
