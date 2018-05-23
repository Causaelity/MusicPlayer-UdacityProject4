package net.drunkdogs.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent currentIntent = getIntent();
        position = currentIntent.getIntExtra("position", -1);

        songImageView = findViewById(R.id.imageView);
        songNameTextView = findViewById(R.id.songNameTextView);
        albumNameTextView = findViewById(R.id.albumNameTextView);

        setupSong(position);


        final Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playButton.getText().toString().equalsIgnoreCase("Play")) {
                    playButton.setText("Pause");
                } else {
                    playButton.setText("Play");
                }
            }
        });

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((position + 1) < totalSongs) {
                    position += 1;
                    setupSong(position);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "No more songs to play", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        Button previousButton = findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((position - 1) >= 0) {
                    position -= 1;
                    setupSong(position);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "You are at the beginning of the list", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    void setupSong(int position) {
        currentSong = SongBank.songs.get(position);
        songNameTextView.setText(currentSong.getSongName());
        albumNameTextView.setText(currentSong.getSongAlbumName());

        if (currentSong.hasImage()) {
            songImageView.setImageResource(currentSong.getImageResourceId());
            songImageView.setVisibility(View.VISIBLE);
        } else {
            songImageView.setVisibility(View.INVISIBLE);
        }

    }
}
