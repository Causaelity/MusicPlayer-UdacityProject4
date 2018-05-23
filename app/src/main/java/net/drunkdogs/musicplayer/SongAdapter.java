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

        Song currentSong = getItem(position);

        TextView songNameTextView = listSongView.findViewById(R.id.songNameTextView);
        songNameTextView.setText(currentSong.getSongName());

        TextView albumNameTextView = listSongView.findViewById(R.id.albumNameTextView);
        albumNameTextView.setText(currentSong.getSongAlbumName());


        ImageView songImageView = listSongView.findViewById(R.id.songImage);

        if (currentSong.hasImage()) {
            songImageView.setImageResource(currentSong.getImageResourceId());
            songImageView.setVisibility(View.VISIBLE);
        } else {
            songImageView.setVisibility(View.GONE);
        }


        return listSongView;
    }
}
