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

    public ArrayList<Song> getPlayList() {
        return mPlayList;
    }

    public Boolean hasPlaylist() {
        return mHasPlaylist;
    }

    public ArrayList<Song> getSongs(){
        return mSongs;
    }

    public Song getSong(int id) {
        int i = 0;
        Song match = mSongs.get(i);
        while (match.getSongId()!=id){
            i++;
            match = mSongs.get(i);
        }
        return match;
    }

    public ArrayList<Song> populateSongList() {
        ArrayList<Song> trackList = new ArrayList<Song>();
        trackList.add(new Song(1, "Michael Jackson", "Dirty Diana", "pop"));
        trackList.add(new Song(2, "Metallica", "Enter Sadman", "rock"));
        trackList.add(new Song(3, "Armin van Buuren feat Josh Cumbee", "Sunny Days", "trance"));
        trackList.add(new Song(4, "Scorpions", "Wind of Change", "rock"));
        trackList.add(new Song(5,"Avicii", "Levels", "club"));
        trackList.add(new Song(6,"Skrillex", "First Of The Year (Equinox)", "dubstep"));
        trackList.add(new Song(7,"Katie Melua", "The Closest Thing To Crazy", "blues"));
        trackList.add(new Song(8,"Pink Floyd", "Another brick in the wall", "rock"));
        trackList.add(new Song(9,"Tiesto", "Lethal Industry", "trance"));
        trackList.add(new Song(10,"R. Kelly", "Thoia Thoing", "R&B"));
        trackList.add(new Song(11,"Guns'n Roses", "Don't cry", "rock"));
        trackList.add(new Song(12,"Kygo", "Firestone", "deep house"));
        trackList.add(new Song(13,"Narcotic", "Liquido", "rock"));
        trackList.add(new Song(14,"Lost Frequencies", "Are you with me", "deep house"));
        trackList.add(new Song(15,"Cosmic Gate", "Exploration Of Space", "trance"));
        trackList.add(new Song(16,"Bon Jovi", "It's My Live", "rock"));

        return trackList;
    }

    /**
     *  Add a track to playlist
     */
    public void addToPlaylist (int id) {
        if (!hasPlaylist()) {
            mPlayList = new ArrayList<Song>();
            mHasPlaylist = true;
        }
        mPlayList.add(this.getSong(id));
    }
}
