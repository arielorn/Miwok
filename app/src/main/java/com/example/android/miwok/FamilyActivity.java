package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father","אבא", R.drawable.family_father));
        words.add(new Word("Mother","אמא", R.drawable.family_mother));
        words.add(new Word("Son","בן", R.drawable.family_son));
        words.add(new Word("Daughter","בת", R.drawable.family_daughter));
        words.add(new Word("Grandmother","סבתא", R.drawable.family_grandmother));
        words.add(new Word("Grandfather","סבא", R.drawable.family_grandfather));

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordsAdapter);
    }
}
