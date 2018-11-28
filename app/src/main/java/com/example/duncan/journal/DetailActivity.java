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
        String Title = (String) intent.getSerializableExtra("Title");
        String Mood = (String) intent.getSerializableExtra("Mood");
        String Content = (String) intent.getSerializableExtra("Content");
        String Timestamp = (String) intent.getSerializableExtra("Timestamp");
        TextView title  = (TextView) findViewById(R.id.entryTitle);
        TextView mood = (TextView) findViewById(R.id.entryMood);
        TextView content = (TextView) findViewById(R.id.entryContent);
        TextView timestamp = (TextView) findViewById(R.id.entryDate);

        title.setText(Title);
        mood.setText(" " + Mood);
        content.setText(Content);
        timestamp.setText(Timestamp);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}