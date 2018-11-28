package com.example.duncan.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        JournalEntry entry = (JournalEntry) intent.getSerializableExtra("entryClicked");

        String title = entry.getTitle();
        String content = entry.getContent();
        String mood = entry.getMood();
        String timestamp = entry.getTimestamp();

        TextView titleView = findViewById(R.id.entryTitle);
        TextView contentView = findViewById(R.id.entryContent);
        TextView moodView = findViewById(R.id.entryMood);
        TextView dateView = findViewById(R.id.entryDate);

        titleView.setText(title);
        contentView.setText(content);
        moodView.setText(mood);
        dateView.setText(timestamp);

    }
}