package com.example.android.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Class that implements parcelable
 * Implemented following Coding in Flow tutorials https://codinginflow.com/ as well as
 * Codepath Android Guides https://github.com/codepath/android_guides/wiki/Using-Parcelable
 */

public class Indochine implements Parcelable {
    private int mCover;
    private String mArtist;
    private String mSong;
    public ArrayList<Indochine> songs;

    public Indochine(){}

    private void Indochine(int cover, String artist, String song){
        this.mCover = cover;
        this.mArtist = artist;
        this.mSong = song;
        this.songs = songs;
    }


    // parcel constructor
    protected Indochine(Parcel in) {
        mCover = in.readInt();
        mArtist = in.readString();
        mSong = in.readString();
        this.songs = in.readArrayList(null);
    }

    // method that un-parcels information OR creates individual views
    public static final Creator <Indochine> CREATOR = new Creator <Indochine>() {
        @Override
        public Indochine createFromParcel(Parcel parcel) {
            return new Indochine(parcel);
        }

        //this is what will let me pass the info to the intent
        @Override
        public Indochine[] newArray(int size) {
            return new Indochine[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCover);
        dest.writeString(this.mArtist);
        dest.writeString(this.mSong);
    }
}
