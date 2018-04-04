package com.example.android.musiclibrary;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    // Constant used for checking the return requestCode form other activity
    static final int PLAYLIST_TRACK = 1;
    static final String SAVED_CURRENT_SONG = "savedSong";
    static final String SAVED_SONG_LIST = "savedSongList";
    static final String HAS_SONG_LOADED = "hasSongLoaded";
    static final String TRACK_INDEX = "trackIndex";

    // SongList object used to generate the playlist
    SongList songList = new SongList();

    // Current song
    Song currentlyPlaying;

    // SongAdapter object used to poulate the playlist ListView
    SongAdapter itemsAdapter;

    // Playlist ListView
    ListView listView;

    // Player TextViews - currently played
    TextView currentSongTextView;
    TextView currentArtistTextView;

    // Player ImageView
    ImageView playImageView;

    // Boolean if the song is loaded in player
    Boolean hasSongLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // target ListView
        listView = (ListView) findViewById(R.id.list);

        // Currently played song texts
        currentSongTextView = (TextView) findViewById(R.id.current_song);
        currentArtistTextView = (TextView) findViewById(R.id.current_artist);

        // Find the View that shows the numbers category
        TextView songs = (TextView) findViewById(R.id.songs_selector);
        songs.setOnClickListener(this);

        // Find the View that shows the artist list
        TextView artists = (TextView) findViewById(R.id.artists_selector);
        artists.setOnClickListener(this);

        // Find the View that shows the genre list
        TextView genre = (TextView) findViewById(R.id.genre_selector);
        genre.setOnClickListener(this);

        // Find the play icon view
        playImageView = (ImageView) findViewById(R.id.play_icon);
        // Set a click listener on play icon
        playImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        // Perform action on click
        switch(view.getId()) {
            case R.id.songs_selector:
                // Create a new intent to open the {@link SongsActivity}
                intent = new Intent(MainActivity.this, SongsActivity.class);
                break;
            case R.id.artists_selector:
                // Create a new intent to open the {@link ArtistsActivity}
                intent = new Intent(MainActivity.this, ArtistsActivity.class);
                break;
            case R.id.genre_selector:
                // Create a new intent to open the {@link genreActivity}
                intent = new Intent(MainActivity.this, GenreActivity.class);
                break;
            case R.id.play_icon:
                // Play the song
                play();
                break;
        }
        // Check if th intent variable is set
        if (intent != null) {
            startActivityForResult(intent, PLAYLIST_TRACK);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save the object
        savedInstanceState.putParcelable(SAVED_SONG_LIST, songList);
        savedInstanceState.putParcelable(SAVED_CURRENT_SONG, currentlyPlaying);
        savedInstanceState.putBoolean(HAS_SONG_LOADED, hasSongLoaded);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Get the saved object
        songList = savedInstanceState.getParcelable(SAVED_SONG_LIST);
        hasSongLoaded = savedInstanceState.getBoolean(HAS_SONG_LOADED);

        // Check if we need to repopulate the player's TextViews
        if (hasSongLoaded) {
            // Get the current song
            currentlyPlaying = savedInstanceState.getParcelable(SAVED_CURRENT_SONG);
            // Update the player TextView
            currentArtistTextView.setText(currentlyPlaying.getArtist());
            currentSongTextView.setText(currentlyPlaying.getSong());
        }
        // Update the adapter
        itemsAdapter = new SongAdapter(this, songList.getPlayList(), R.layout.playlist_item, this);

        // Set the adapter
        listView.setAdapter(itemsAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Check the requestCode
        if (requestCode == PLAYLIST_TRACK) {

            // Check if has some result set
            if (resultCode == RESULT_OK) {

                // Get the trackIndex returned
                int trackIndex = (int) data.getExtras().getInt(TRACK_INDEX);

                // Add the song at trackIndex
                songList.addToPlaylist(trackIndex);

                // Update the adapter
                itemsAdapter = new SongAdapter(this, songList.getPlayList(), R.layout.playlist_item, this);

                // Set the adapter
                listView.setAdapter(itemsAdapter);
            }
        }
    }

    /**
     * Play the song
     */
    private void play() {

        // check if playlist has song items
        if (songList.hasPlaylist()) {

            if (!hasSongLoaded) {
                // Get the first song in playlist
                currentlyPlaying = songList.getPlayList().get(0);
                // load the next song
                loadNextSongToPlayer();
            }

            // Change icon to pause
            playImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause));

            // Set onClick listener
            playImageView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    // When clicked play the song.
                    pause();
                }
            });
        } else {
            Toast.makeText(this, "Add some songs to the playlist", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Pause the song
     */
    private void pause() {

        // Change icon to pause
        playImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_play));

        // Set onClick listener
        playImageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // When clicked play the song.
                play();
            }
        });
    }

    /**
     * Load the next song to player
     */
    private void loadNextSongToPlayer() {

        // Update the player TextView
        currentArtistTextView.setText(currentlyPlaying.getArtist());
        currentSongTextView.setText(currentlyPlaying.getSong());

        // Change icon to pause
        playImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause));

        // Remove the song from adapter
        itemsAdapter.remove(currentlyPlaying);

        // Set the isLoaded Boolean to true
        hasSongLoaded = true;
    }
}
