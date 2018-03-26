package com.example.android.musiclibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Levy on 21.03.2018.
 */

public class SongList {
    private ArrayList<Song> mSongs;
    private ArrayList<Song> mPlayList;
    private Boolean mHasPlaylist = false;

    /**
     * Constructor
     * @return ArrayList of Song objects
     */
    public SongList () {
        mSongs = populateSongList();
    }

    /**
     * Get the songs added to playlist
     * @return ArrayList of Song objects
     */
    public ArrayList<Song> getPlayList() {
        return mPlayList;
    }

    /**
     * Check if the object has a playlist created
     * @return Boolean
     */
    public Boolean hasPlaylist() {
        return mHasPlaylist;
    }

    /**
     * Get the list unordered
     * @return ArrayList of Song objects
     */
    public ArrayList<Song> getSongs(){
        return mSongs;
    }

    /**
     * Get the list ordered by title
     * @return ArrayList of Song objects ordered by title
     */
    public ArrayList<Song> getSongsByTitle(){

        // Variable to return the sorted ArrayList
        ArrayList<Song> sortedList = mSongs;

        // Sort the list by song title
        // from https://stackoverflow.com/questions/9109890/android-java-how-to-sort-a-list-of-objects-by-a-certain-value-within-the-object
        Collections.sort(sortedList, new Comparator<Song>(){
            public int compare(Song obj1, Song obj2) {
                // ## Ascending order
                return obj1.getSong().compareToIgnoreCase(obj2.getSong()); // To compare string values
            }
        });

        return sortedList;
    }

    /**
     * Get the list ordered by artist
     * @return ArrayList of Song objects ordered by artist
     */
    public ArrayList<Song> getSongsByArtist(){

        // Variable to return the sorted ArrayList
        ArrayList<Song> sortedList = mSongs;

        // Sort the list by artist
        // from https://stackoverflow.com/questions/9109890/android-java-how-to-sort-a-list-of-objects-by-a-certain-value-within-the-object
        Collections.sort(sortedList, new Comparator<Song>(){
            public int compare(Song obj1, Song obj2) {
                // ## Ascending order
                return obj1.getArtist().compareToIgnoreCase(obj2.getArtist()); // To compare string values
            }
        });

        return sortedList;
    }

    /**
     * Get the list ordered by genre
     * @return ArrayList of Song objects ordered by genre
     */
    public ArrayList<Song> getSongsByGenre(){

        // Variable to return the sorted ArrayList
        ArrayList<Song> sortedList = mSongs;

        // Sort the list by artist
        // from https://stackoverflow.com/questions/9109890/android-java-how-to-sort-a-list-of-objects-by-a-certain-value-within-the-object
        Collections.sort(sortedList, new Comparator<Song>(){
            public int compare(Song obj1, Song obj2) {
                // ## Ascending order
                return obj1.getGenre().compareToIgnoreCase(obj2.getGenre()); // To compare string values
            }
        });

        return sortedList;
    }

    /**
     * Get a song by id form an ArrayList
     * @param id
     * @return Song object
     */
    public Song getSong(int id) {
        int i = 0;
        Song match = mSongs.get(i);
        while (match.getSongId()!=id){
            i++;
            match = mSongs.get(i);
        }
        return match;
    }

    /**
     *  Add a Song to playlist
     *  @param id
     */
    public void addToPlaylist (int id) {
        if (!hasPlaylist()) {
            mPlayList = new ArrayList<Song>();
            mHasPlaylist = true;
        }
        mPlayList.add(this.getSong(id));
    }

    /**
     * Populate the SongList object with some values
     * @return ArrayList with Song objects
     */
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
}
