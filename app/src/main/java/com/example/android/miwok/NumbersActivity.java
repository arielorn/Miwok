package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","אחד", R.drawable.number_one));
        words.add(new Word("Two","שתיים", R.drawable.number_two));
        words.add(new Word("Three","שלוש", R.drawable.number_three));
        words.add(new Word("Four","ארבע", R.drawable.number_four));
        words.add(new Word("Five","חמש", R.drawable.number_five));
        words.add(new Word("Six","שש", R.drawable.number_six));
        words.add(new Word("Seven","שבע", R.drawable.number_seven));
        words.add(new Word("Eight","שמונה", R.drawable.number_eight));
        words.add(new Word("Nine","תשע", R.drawable.number_nine));
        words.add(new Word("Ten","עשר", R.drawable.number_ten));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);


    }
}
