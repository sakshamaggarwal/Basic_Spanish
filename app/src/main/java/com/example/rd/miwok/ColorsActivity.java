package com.example.rd.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /*ALL STEPS FOR NUMBERS PAGE
        1. Create a way to store custom objects ---- this is done in our Word.java class and then --- we made an arrayList numberWords which is of Word type
        2. Create a custom adapter that extends from ArrayAdapter and takes a custom object --- This is done in WordAdapter.java class --- where WordAdapter extends from ArrayAdapter<Word> --- ArrayAdapter takes custom object Word
        3. Modified getView() method in the custom adapter to provide a list item view for your ListView --- We modified it to get Word object from the ArrayAdapter at the appropriate position and either use that information to populate a recycled view or to populate a newly created view
        *
        * */
        //Making ArrayList of type Word i.e. to store numbers from one to ten in both english and spanish
        final ArrayList<Word> numberWords = new ArrayList<Word>();
        numberWords.add(new Word("red","rojo",R.drawable.color_red,R.raw.color_red));
        numberWords.add(new Word("green","verde",R.drawable.color_green,R.raw.color_green));
        numberWords.add(new Word("brown","marron",R.drawable.color_brown,R.raw.marron));
        numberWords.add(new Word("gray","gris",R.drawable.color_gray,R.raw.color_gray));
        numberWords.add(new Word("white","blanco",R.drawable.color_white,R.raw.color_white));
        numberWords.add(new Word("yellow","amarillo",R.drawable.color_dusty_yellow,R.raw.color_yellow));
        numberWords.add(new Word("black","negro",R.drawable.color_black,R.raw.color_black));



        WordAdapter adapter = new WordAdapter(this, numberWords, R.color.colorAccent, R.color.category_colors_text);
        //Get a reference to the listView and attach the adapter to the list view
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = numberWords.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getSoundResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
