package net.drunkdogs.musicplayer;

import java.util.ArrayList;

public class SongBank {

    public static ArrayList<Song> getAllSongs() {
        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Dancing Queen", "Gold: Greatest Hits", R.drawable.abba_album));
        songs.add(new Song("Super Trouper", "Gold: Greatest Hits", R.drawable.abba_album));
        songs.add(new Song("Money, Money, Money", "Gold: Greatest Hits", R.drawable.abba_album));
        songs.add(new Song("Why Do We Fall?", "Music from the Batman Trilogy", R.drawable.batman_album));
        songs.add(new Song("Antrozous", "Music from the Batman Trilogy", R.drawable.batman_album));
        songs.add(new Song("Imagine the Fire", "Music from the Batman Trilogy", R.drawable.batman_album));
        songs.add(new Song("Dies Mercurii I Martius", "The DaVinci Code", R.drawable.davinci_album));
        songs.add(new Song("L'Espirit des Gabriel", "The DaVinci Code", R.drawable.davinci_album));

        // No image intentionally supplied
        songs.add(new Song("Hells Bells", "Back in Black"));

        // Other songs with images
        songs.add(new Song("Fructus Gravis", "The DaVinci Code", R.drawable.davinci_album));
        songs.add(new Song("Look to the Stars", "Man of Steel", R.drawable.manofsteel_album));
        songs.add(new Song("Oil Rig", "Man of Steel", R.drawable.manofsteel_album));
        songs.add(new Song("Goodbye My Son", "Man of Steel", R.drawable.manofsteel_album));
        songs.add(new Song("Ancient Sorcerer's Secret", "Doctor Strange", R.drawable.drstrange_album));
        songs.add(new Song("Go for Baroque", "Doctor Strange", R.drawable.drstrange_album));
        songs.add(new Song("Reading is Fundamental", "Doctor Strange", R.drawable.drstrange_album));

        return songs;
    }
}
