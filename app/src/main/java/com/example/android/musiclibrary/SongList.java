package com.example.android.musiclibrary;

import java.util.ArrayList;

/**
 * Created by Levy on 21.03.2018.
 */

public class SongList {
    private ArrayList<Song> mSongs;
    private ArrayList<Song> mPlayList;
    private Boolean mHasPlaylist = false;
    /**
     * Constructor
     * @return
     */
    public SongList () {
        mSongs = populateSongList();
    }

    public  ArrayList<Song> getPlayList() {
        return mPlayList;
    }

    public Boolean hasPlaylist() {
        return mHasPlaylist;
    }

    public ArrayList<Song> getSongs(){
        return mSongs;
    }

    public ArrayList<Song> populateSongList() {
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

        return trackList;
    }

    /**
     *  Add a track to playlist
     */
    public void addToPlaylist (int trackIndex) {
        mPlayList.add(mSongs.get(trackIndex));
    }
}
