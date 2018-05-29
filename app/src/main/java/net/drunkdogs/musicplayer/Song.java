package net.drunkdogs.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    private String mSongName;

    private String mSongAlbumName;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Song(String songName, String songAlbumName) {
        mSongName = songName;
        mSongAlbumName = songAlbumName;
    }

    public Song(String songName, String songAlbumName, int imageResourceId) {
        mSongName = songName;
        mSongAlbumName = songAlbumName;
        mImageResourceId = imageResourceId;
    }

    public String getSongName() { return mSongName; }

    public String getSongAlbumName() { return mSongAlbumName; }

    public int getImageResourceId() { return mImageResourceId; }

    public boolean hasImage() { return mImageResourceId != NO_IMAGE_PROVIDED; }

    @Override
    public String toString() {
        return "Song{" +
                "mSongName=" + mSongName +
                ", mSongAlbum=" + mSongAlbumName +
                ", mImageResourceId=" + mImageResourceId + "}";
    }

    /**
     * Parcelable Code
     */

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeString(mSongAlbumName);
        dest.writeInt(mImageResourceId);
    }

    private Song(Parcel in) {
        mSongName = in.readString();
        mSongAlbumName = in.readString();
        mImageResourceId = in.readInt();
    }

    // Method to recreate a Song from a Parcel
    public static Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

}
