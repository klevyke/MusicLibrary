package com.example.android.musiclibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                startActivity(songsIntent);
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
                startActivity(artistsIntent);
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
                startActivity(genreIntent);
            }
        });

        ArrayList<Song> trackList = new ArrayList<Song>();
        trackList.add(new Song("Michael Jackson", "Dirty Diana", "pop"));
        trackList.add(new Song("Metallica", "Enter Sadman", "rock"));
        trackList.add(new Song("Armin van Buuren feat Josh Cumbee", "Sunny Days", "trance"));
        trackList.add(new Song("Scorpions", "Wind of Change", "rock"));
        trackList.add(new Song("Avicii", "Levels", "club"));
        trackList.add(new Song("Skrillex", "First Of The Year (Equinox)", "dubstep"));
        trackList.add(new Song("Katie Melua", "The Closest Thing To Crazy", "blues"));
        trackList.add(new Song("Pink Floyd", "Another brick in the wall", "rock"));
        trackList.add(new Song("Tiesto", "Lethal Industry", "trance"));
        trackList.add(new Song("R. Kelly", "Thoia Thoing", "R&B"));
        trackList.add(new Song("Guns'n Roses", "Don't cry", "rock"));
        trackList.add(new Song("Kygo", "Firestone", "deep house"));
        trackList.add(new Song("Narcotic", "Liquido", "rock"));
        trackList.add(new Song("Lost Frequencies", "Are you with me", "deep house"));
        trackList.add(new Song("Cosmic Gate", "Exploration Of Space", "trance"));
        trackList.add(new Song("Bon Jovi", "It's My Live", "rock"));

    }
}
