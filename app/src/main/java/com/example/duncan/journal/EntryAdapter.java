package com.example.duncan.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.entry_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView titleText = view.findViewById(R.id.titleText);
        String title = cursor.getString(cursor.getColumnIndex("title"));
        titleText.setText(title);

        TextView dateText = view.findViewById(R.id.dateText);
        String timestamp = cursor.getString(cursor.getColumnIndex("timestamp"));
        dateText.setText(timestamp);

        TextView moodText = view.findViewById(R.id.moodText);
        String mood = cursor.getString(cursor.getColumnIndex("mood"));
        moodText.setText(mood);
    }
}