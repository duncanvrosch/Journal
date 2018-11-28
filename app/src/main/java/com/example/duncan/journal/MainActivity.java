package com.example.duncan.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity {

    EntryDatabase db;
    EntryAdapter entryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.listView);
        listview.setOnItemClickListener(new OnItemClickListener());
        listview.setOnItemLongClickListener(new OnItemLongClickListener());

        db = EntryDatabase.getInstance(getApplicationContext());

        Cursor cursor = db.selectAll();
        entryAdapter = new EntryAdapter(getApplicationContext(), cursor);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(entryAdapter);
    }

    public void ButtonClick(View v) {

        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    private class OnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            String mood = cursor.getString(cursor.getColumnIndex("mood"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            String timestamp = cursor.getString(cursor.getColumnIndex("timestamp"));

            JournalEntry entryClicked = new JournalEntry(title, content, mood, timestamp);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("entryClicked", entryClicked);
            startActivity(intent);
        }
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            long entryId = cursor.getLong(cursor.getColumnIndex("_id"));
            db.deleteEntry(entryId);
            updateData();
            return true;
        }
    }

    @Override
    protected void onResume (){
        super.onResume();
        updateData();
    }

    private void updateData() {
        Cursor newCursor = db.selectAll();
        entryAdapter.swapCursor(newCursor);
    }
}