package net.drunkdogs.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayingActivity extends AppCompatActivity {

    int position;
    int totalSongs = SongBank.songs.size();

    Song currentSong;
    TextView songNameTextView;
    TextView albumNameTextView;
    ImageView songImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        // Add a return to previous screen in top left corner
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get array position ID passed from previous Intent
        Intent currentIntent = getIntent();
        position = currentIntent.getIntExtra("position", 0);

        // Setup views
        songImageView = findViewById(R.id.imageView);
        songNameTextView = findViewById(R.id.songNameTextView);
        albumNameTextView = findViewById(R.id.albumNameTextView);

        // Update display with song details
        setupSong(position);

        // Allow Play / Pause Toggle
        final Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playButton.getText().toString().equalsIgnoreCase("Play")) {
                    playButton.setText(R.string.pause);
                } else {
                    playButton.setText(R.string.play);
                }
            }
        });

        // Forward to next song in list, otherwise toast a message if at end of list.
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((position + 1) < totalSongs) {
                    position += 1;
                    setupSong(position);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.endOfListMessage, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        // Go back a song, otherwise toast a message if first song in list.
        Button previousButton = findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((position - 1) >= 0) {
                    position -= 1;
                    setupSong(position);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.startOfListMessage, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


    }

    // Return to previous activity
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    // Set up view with song details
    void setupSong(int position) {
        currentSong = SongBank.songs.get(position);
        songNameTextView.setText(currentSong.getSongName());
        albumNameTextView.setText(currentSong.getSongAlbumName());

        // Use below line if you want song title in Action Bar
//        getSupportActionBar().setTitle(currentSong.getSongName());

        if (currentSong.hasImage()) {
            songImageView.setImageResource(currentSong.getImageResourceId());
            songImageView.setVisibility(View.VISIBLE);
        } else {
            songImageView.setVisibility(View.INVISIBLE);
        }

    }
}
