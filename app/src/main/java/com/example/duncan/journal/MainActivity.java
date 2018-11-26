package com.example.duncan.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.listView);
        listview.setOnItemClickListener(new OnItemClickListener());

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());

        // create cursor
        Cursor cursor = db.selectAll();

        // link listview to adapter
        EntryAdapter entryAdapter = new EntryAdapter(getApplicationContext(), cursor);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(entryAdapter);
    }

    // listener for floating action button
    public void faButtonClick(View v) {

        // redirect user to new entry activity
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }



    private class OnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // TODO

        }
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {




            return true;
        }
    }
}
