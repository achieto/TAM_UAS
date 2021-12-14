package com.example.prianly;

import android.os.Parcel;
import android.os.Parcelable;

public class Lyrics implements Parcelable{
    private String title;
    private String singer;
    private int image;
    private String lyric;

    protected Lyrics(Parcel in) {
        title = in.readString();
        singer = in.readString();
        image = in.readInt();
        lyric = in.readString();
    }

    public static final Creator<Lyrics> CREATOR = new Creator<Lyrics>() {
        @Override
        public Lyrics createFromParcel(Parcel in) {
            return new Lyrics(in);
        }

        @Override
        public Lyrics[] newArray(int size) {
            return new Lyrics[size];
        }
    };

    public Lyrics(String title, String singer, int image, String lyric) {
        this.title = title;
        this.singer = singer;
        this.image = image;
        this.lyric = lyric;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(singer);
        parcel.writeInt(image);
        parcel.writeString(lyric);
    }
}
