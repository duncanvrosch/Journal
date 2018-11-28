package com.example.duncan.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    @Override
    public void onCreate(SQLiteDatabase db) {

        String entries = "CREATE TABLE entries (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, mood TEXT, timestamp DATETIME DEFAULT (datetime('now')))";
        db.execSQL(entries);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + "entries");
        onCreate(db);
    }

    private EntryDatabase(Context context) {
        super(context, "entries", null, 1);
    }

    public static EntryDatabase getInstance(Context context) {

        if (instance != null) {
            return instance;
        }

        instance = new EntryDatabase(context);
        return instance;
    }

    public Cursor selectAll() {
        SQLiteDatabase database = getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM entries", null);
        return cursor;
    }

    public void insert(JournalEntry newEntry) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues entry = new ContentValues();

        entry.put("title", newEntry.getTitle());
        entry.put("content", newEntry. getContent());
        entry.put("mood", newEntry.getMood());

        database.insert("entries", null, entry);
    }

    public void deleteEntry(long id) {

        SQLiteDatabase database = getWritableDatabase();
        String query = "DELETE FROM entries WHERE _ID = " + id;
        database.execSQL(query);

    }
}