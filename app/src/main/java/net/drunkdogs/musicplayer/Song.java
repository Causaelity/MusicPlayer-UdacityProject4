package net.drunkdogs.musicplayer;

public class Song {

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
}
