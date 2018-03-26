package com.example.android.musiclibrary;

/**
 * Created by Levy on 21.03.2018.
 */

public class Song {
    private int mSongId;
    private String mArtist;
    private String mSong;
    private String mGenre;

    public Song(int id, String artist, String song, String genre) {
        mSongId = id;
        mArtist = artist;
        mSong = song;
        mGenre = genre;
    }

    public int getSongId() {
        return mSongId;
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
