package com.example.rd.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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
        numberWords.add(new Word("Good Evening","Buena noches",R.raw.phrases_good_evening));
        numberWords.add(new Word("What is your name?","¿Como te llamas?",R.raw.phrases_whats_ur_name));
        numberWords.add(new Word("How are you?","¿Como estas?",R.raw.phrases_how_are_you));
        numberWords.add(new Word("Goodbye","Adios",R.raw.phrases_goodbye));
        numberWords.add(new Word("See You Later","Hasta la vista",R.raw.phrases_see_you_later));
        numberWords.add(new Word("What's the date?","¿A cuánto estamos hoy?",R.raw.phrases_whats_the_date));
        numberWords.add(new Word("Who is calling?","¿De parte de quién?",R.raw.phrases_who_is_calling));


        WordAdapter adapter = new WordAdapter(this, numberWords, R.color.category_phrases, R.color.category_phrases_text);
        //Get a reference to the listView and attach the adapter to the list view
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = numberWords.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getSoundResourceId());
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
