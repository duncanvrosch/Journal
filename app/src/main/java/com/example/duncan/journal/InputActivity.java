package com.example.duncan.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void addEntry(View v) {

        EditText titleEdit = findViewById(R.id.titleEdit);
        String title = titleEdit.getText().toString();
        EditText entryEdit = findViewById(R.id.entryEdit);
        String entry = entryEdit.getText().toString();
        EditText moodEdit = findViewById(R.id.moodEdit);
        String mood = moodEdit.getText().toString();

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        JournalEntry newEntry = new JournalEntry(title, entry, mood, timeStamp);

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());

        db.insert(newEntry);

        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
    }
}