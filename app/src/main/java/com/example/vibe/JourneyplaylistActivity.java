package com.example.vibe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vibe.adapter.Music_Adapter;
import com.example.vibe.model.Music;

import java.util.ArrayList;
import java.util.List;

public class JourneyplaylistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Music_Adapter music_adapter;
    List<Music> list= new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journeyplaylist);
        recyclerView=findViewById(R.id.journey);
        music_adapter=new Music_Adapter(list);
        recyclerView.setAdapter(music_adapter);
        loadMusic();
    }
    private void loadMusic() {
        list.add(new Music("","","","",""));
        list.add(new Music("","","","",""));
        list.add(new Music("","","","",""));
        list.add(new Music("","","","",""));
        list.add(new Music("","","","",""));
        list.add(new Music("","","","",""));
        list.add(new Music("","","","",""));
        music_adapter.notifyDataSetChanged();

    }
}