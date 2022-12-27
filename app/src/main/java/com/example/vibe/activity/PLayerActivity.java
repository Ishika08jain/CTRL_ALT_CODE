package com.example.vibe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vibe.R;

import java.util.jar.Attributes;

public class PLayerActivity extends AppCompatActivity {
    String musicTitle, musicPath,musicDuration,musicAlbum,musicArtist;
    ImageView back,play,next,pre;
    TextView title;
    ImageButton imageButton;

    MediaPlayer mPlayer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Bundle bundle = getIntent().getExtras();
        musicTitle=bundle.getString( "title");
        musicPath=bundle.getString( "path");
        musicDuration=bundle.getString(  "dur");
        musicAlbum=bundle.getString(  "album");
        musicArtist=bundle.getString(  "artist");
        play=findViewById(R.id.btn_play);
        pre=findViewById(R.id.btn_pre);
        next=findViewById(R.id.btn_next);
        title=findViewById(R.id.music_title);
        imageButton=findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        initMusic();
    title.setText(musicTitle);
    play.setOnClickListener(v-> {
        if(mPlayer.isPlaying()){
            play.setImageResource(R.drawable.ic_play);
            mPlayer.pause();
        }else{
            play.setImageResource(R.drawable.ic_pause);
            mPlayer.start();

        }
    });
    pre.setOnClickListener(v-> {
    });
    back.setOnClickListener(v-> {
        finish();
    });
    }

    private void initMusic() {


        mPlayer=new MediaPlayer();
        //mPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).setUsage(Attributes.USAGE_MEDIA));
        //try {
         //   mPlayer.setDataSource(musicPath);
           // mPlayer.prepareAsync();
       // }catch (Exception e) {
          //  Toast.makeText( this, "Error Music Can't play",Toast.LENGTH_SHORT).show();
        //}
       /// mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        //    @Override
        //    public void onPrepared(MediaPlayer mediaPlayer) {
         //       play.setImageResource(R.drawable.ic_pause);
          //      mediaPlayer.start();
          //  }
        //});

    }
}