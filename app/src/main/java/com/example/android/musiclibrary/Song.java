package com.example.android.musiclibrary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Levy on 21.03.2018.
 */

public class Song implements Parcelable {
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

    /**
     * Parcelable implementation
     * generated on parcelabler.com
     */

    protected Song(Parcel in) {
        mSongId = in.readInt();
        mArtist = in.readString();
        mSong = in.readString();
        mGenre = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSongId);
        dest.writeString(mArtist);
        dest.writeString(mSong);
        dest.writeString(mGenre);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
