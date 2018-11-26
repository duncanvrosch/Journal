package com.example.duncan.journal;

import java.io.Serializable;
import java.sql.Timestamp;

public class JournalEntry implements Serializable {

    int id;
    String title, content, mood;
    Timestamp timestamp;

    // constructor
    public JournalEntry(int id, String title, String content, String mood, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    // TODO GETTERS AND SETTERS
}
