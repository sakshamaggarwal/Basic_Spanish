package com.example.rd.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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
        numberWords.add(new Word("one","uno",R.drawable.number_one,R.raw.number_one));
        numberWords.add(new Word("two","dos",R.drawable.number_two,R.raw.number_two));
        numberWords.add(new Word("three","tres",R.drawable.number_three,R.raw.number_three));
        numberWords.add(new Word("four","quatro",R.drawable.number_four,R.raw.number_four));
        numberWords.add(new Word("five","cinco",R.drawable.number_five,R.raw.number_five));
        numberWords.add(new Word("six","sies",R.drawable.number_six,R.raw.number_six));
        numberWords.add(new Word("seven","siete",R.drawable.number_seven,R.raw.number_seven));
        numberWords.add(new Word("eight","ocho",R.drawable.number_eight,R.raw.number_eight));
        numberWords.add(new Word("nine","nueve",R.drawable.number_nine,R.raw.number_nine));
        numberWords.add(new Word("ten","diez",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter adapter = new WordAdapter(this, numberWords, R.color.category_numbers, R.color.category_number_text);
        //Get a reference to the listView and attach the adapter to the list view

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = numberWords.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getSoundResourceId());
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
