package com.example.android.musiclibrary;

/**
 * Created by Levy on 21.03.2018.
 */

public class Song {
    private String mArtist;
    private String mSong;
    private String mGenre;

    public Song(String artist, String song, String genre) {
        mArtist = artist;
        mSong = song;
        mGenre = genre;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getGenre() {
        return mGenre;
    }

    public String getSong() {
        return mSong;
    }
}
