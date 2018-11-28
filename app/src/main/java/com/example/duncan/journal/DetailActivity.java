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

        JournalEntry entry = (JournalEntry) intent.getSerializableExtra("clicked_entry");

        String title = entry.getTitle();
        TextView titleView = findViewById(R.id.entryTitle);
        titleView.setText(title);

        String content = entry.getContent();
        TextView contentView = findViewById(R.id.entryContent);
        contentView.setText(content);

        String mood = entry.getMood();
        TextView moodView = findViewById(R.id.entryMood);
        moodView.setText(mood);

        String timestamp = entry.getTimestamp();
        TextView dateView = findViewById(R.id.entryDate);
        dateView.setText(timestamp);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}