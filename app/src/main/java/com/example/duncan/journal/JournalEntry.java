package com.example.duncan.journal;

import java.io.Serializable;
import java.sql.Timestamp;

public class JournalEntry implements Serializable {

    String title, content, mood, timestamp;

    public JournalEntry(String title, String content, String mood, String timestamp) {
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    public String getTimestamp() {
        return timestamp;
    }
}