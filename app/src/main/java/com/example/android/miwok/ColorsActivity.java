package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.list;

public class ColorsActivity extends AppCompatActivity {

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
        words.add(new Word("Red","אדום", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Green","ירוק",R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Brown","חום", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Gray","אפור", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Black","שחור", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("White","לבן", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("Dusty Yellow","צהוב מיוחד", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Mustard Yellow","צהוב חרדל", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Word word = words.get(position);
                if (mPlayer != null)
                    releaseMediaPlayer();
                mPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
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
