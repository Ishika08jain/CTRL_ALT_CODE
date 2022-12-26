package com.example.vibe.helper;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.vibe.model.Music;

import java.util.ArrayList;
import java.util.List;

public class helper {

    public static List<Music> allMusic = new ArrayList<>();
    public static boolean isLoaded = false;
    private static Context context;

    public static void getAllMusic(Activity Context){
        int pos = 0;
        List <Music> tempList = new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] datas = {MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.ARTIST};
       Cursor cr = context.getContentResolver().query(uri, datas, null, null, null);

       if(cr!= null){
           while(cr.moveToNext()) {

               String path = cr.getString(0);
               String title = path.substring(path.lastIndexOf('/') + 1);
               String album = cr.getString(1);
               String artist = cr.getString(2);
               String duration = "";

               tempList.add(new Music(title, artist, album, path, duration));


           }

           allMusic.addAll(tempList);
           helper.isLoaded= true;
       }



    }
}
