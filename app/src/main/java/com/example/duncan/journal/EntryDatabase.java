package com.example.duncan.journal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Map;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    @Override
    public void onCreate(SQLiteDatabase db) {

        String entries = "CREATE TABLE entries (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, mood TEXT, timestamp TIMESTAMP)";
        db.execSQL(entries);

        String sample1 = "INSERT INTO entries (title, content, mood) VALUES ('Maandag', 'Vandaag was het maandag.', 'blij')";
        String sample2 = "INSERT INTO entries (title, content, mood) VALUES ('Dinsdag', 'Vandaag was het dinsdag.', 'verdrietig')";
        db.execSQL(sample1);
        db.execSQL(sample2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // recreate table
        onCreate(db);
    }

    private EntryDatabase(Context context, String name) {
        super(context, name, null, 1);
    }

    public static EntryDatabase getInstance(Context context) {

        // if database already exists, return it
        if (instance != null) {
            return instance;
        }

        // else, create it
        instance = new EntryDatabase(context, "entries");
        return instance;
    }

    public Cursor selectAll() {
        SQLiteDatabase database = getWritableDatabase();

        // grab cursor
        Cursor cursor = database.rawQuery("SELECT * FROM entries", null);
        return cursor;
    }

    // insert entry
    public void insert(Map.Entry entry) {

    }
}