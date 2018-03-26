package com.example.android.musiclibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Constant used for checking the return requestCode form other activity
    static final int PLAYLIST_TRACK = 1;

    // SongList object used to generate the playlist
    SongList songList = new SongList();

    // SongAdapter object used to poulate the playlist ListView
    SongAdapter itemsAdapter;

    // Playlist ListView
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        // Find the View that shows the numbers category
        TextView songs = (TextView) findViewById(R.id.songs_selector);

        // Set a click listener on that View
        songs.setOnClickListener(new OnClickListener() {
            // When songs is clicked on.

            @Override
            public void onClick(View view) {

                // Create a new intent to open the {@link SongsActivity}
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);

                // Start the new activity
                startActivityForResult(songsIntent,PLAYLIST_TRACK);
            }
        });

        // Find the View that shows the artist list
        TextView artists = (TextView) findViewById(R.id.artists_selector);

        // Set a click listener on that View
        artists.setOnClickListener(new OnClickListener() {
            // When artists is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ArtistActivity}
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);

                // Start the new activity
                startActivityForResult(artistsIntent,PLAYLIST_TRACK);
            }
        });

        // Find the View that shows the colors category
        TextView genre = (TextView) findViewById(R.id.genre_selector);

        // Set a click listener on that View
        genre.setOnClickListener(new OnClickListener() {
            // When genre is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link GenreActivity}
                Intent genreIntent = new Intent(MainActivity.this, GenreActivity.class);

                // Start the new activity
                startActivityForResult(genreIntent,PLAYLIST_TRACK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Check the requestCode
        if (requestCode == PLAYLIST_TRACK) {

            // Check if has some result set
            if (resultCode == RESULT_OK) {

                // Get the trackIndex returned
                int trackIndex = (int) data.getExtras().getInt("TRACK_INDEX");

                // Add the song at trackIndex
                songList.addToPlaylist(trackIndex);

                // Update the adapter
                itemsAdapter = new SongAdapter(this, songList.getPlayList(), R.layout.playlist_item, this);

                // Set the adapter
                listView.setAdapter(itemsAdapter);
            }
        }
    }
}
