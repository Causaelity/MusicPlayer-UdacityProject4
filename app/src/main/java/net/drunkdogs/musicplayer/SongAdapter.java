package net.drunkdogs.musicplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused or inflate a new one
        View listSongView = convertView;
        if (listSongView == null) {
            listSongView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        // Get current song
        Song currentSong = getItem(position);

        // Update song name
        TextView songNameTextView = listSongView.findViewById(R.id.songNameTextView);
        songNameTextView.setText(currentSong.getSongName());

        // Update album name
        TextView albumNameTextView = listSongView.findViewById(R.id.albumNameTextView);
        albumNameTextView.setText(currentSong.getSongAlbumName());

        // Update image
        ImageView songImageView = listSongView.findViewById(R.id.songImage);

        // If song has an associated image use it, otherwise remove space
        if (currentSong.hasImage()) {
            songImageView.setImageResource(currentSong.getImageResourceId());
            songImageView.setVisibility(View.VISIBLE);
        } else {
            songImageView.setVisibility(View.GONE);
        }

        return listSongView;
    }
}
