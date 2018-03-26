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

        // create a new song list form SongList object
        ArrayList<Song> songs = new SongList().getSongs();

        // Create a SongAdapter to populate the songs listView
        SongAdapter itemsAdapter = new SongAdapter(this, songs, R.layout.songs_item, this);

        // Get the listView for the song list
        ListView listView = (ListView) findViewById(R.id.list);

        // Set the adapter
        listView.setAdapter(itemsAdapter);

    }
}