package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?","לאן אתה הולך?", -1, R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","מה השם שלך?", -1, R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","שמי הוא...", -1, R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","איך אתה מרגיש?", -1, R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.","אני מרגיש טוב.", -1, R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","האם אתה בא?", -1, R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.","כן, אני בא.", -1, R.raw.phrase_yes_im_coming));
        words.add(new Word("Let’s go.","בוא נלך.", -1, R.raw.phrase_lets_go));
        words.add(new Word("Come here.","בוא הנה.", -1, R.raw.phrase_come_here));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);

     listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {
            Word word = words.get(position);
            if (mPlayer != null)
                releaseMediaPlayer();
            mPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
            mPlayer.start();
            mPlayer.setOnCompletionListener(mOnCompletionListener);
        }

    });
}

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mPlayer = null;
        }
    }
}
