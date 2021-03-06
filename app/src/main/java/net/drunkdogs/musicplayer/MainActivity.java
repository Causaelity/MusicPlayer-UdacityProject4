package net.drunkdogs.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean songAscending = true;
    boolean albumAscending = true;
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup and initialize song list
         songs = SongBank.getAllSongs();

        // Create adapter to use with array list
        final SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.songListView);

        listView.setAdapter(adapter);

        // Add click functionality to list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Launch this song to a detail view
                Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                intent.putExtra("position", position);

                // parceled song class in an array
                intent.putParcelableArrayListExtra("allSongs", songs);

                startActivity(intent);

            }
        });

        // Song Sorting for Songs and Albums
        // Clicking a second time will reverse the sort
        TextView songSort = findViewById(R.id.songSortTextView);
        songSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do some sorting
                if (songAscending) {
                    Collections.sort(songs, new Comparator<Song>() {
                        @Override
                        public int compare(Song o1, Song o2) {
                            return o1.getSongName().compareTo(o2.getSongName());
                        }
                    });
                    songAscending = false;
                } else {
                    Collections.sort(songs, new Comparator<Song>() {
                        @Override
                        public int compare(Song o1, Song o2) {
                            return o2.getSongName().compareTo(o1.getSongName());
                        }
                    });
                    songAscending = true;
                }

                // update the array
                adapter.notifyDataSetChanged();
            }
        });

        TextView albumSort = findViewById(R.id.albumSortTextView);
        albumSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do some sorting
                if (albumAscending) {
                    Collections.sort(songs, new Comparator<Song>() {
                        @Override
                        public int compare(Song o1, Song o2) {
                            return o1.getSongAlbumName().compareTo(o2.getSongAlbumName());
                        }
                    });
                    albumAscending = false;
                } else {
                    Collections.sort(songs, new Comparator<Song>() {
                        @Override
                        public int compare(Song o1, Song o2) {
                            return o2.getSongAlbumName().compareTo(o1.getSongAlbumName());
                        }
                    });
                    albumAscending = true;
                }

                // update the array
                adapter.notifyDataSetChanged();
            }
        });

        TextView originalSort = findViewById(R.id.originalSortTextView);
        originalSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songs.clear();
                songs = SongBank.getAllSongs();

                adapter.notifyDataSetChanged();
            }
        });
    }
}
