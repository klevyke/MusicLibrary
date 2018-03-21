package com.example.android.musiclibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Levy on 21.03.2018.
 */

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list);

        ArrayList<Song> songs = new SongList().getSongs();

        SongAdapter itemsAdapter = new SongAdapter(this, songs, R.layout.songs_item);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }

}