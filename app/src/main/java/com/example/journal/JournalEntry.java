package com.example.journal;


import android.content.Context;

import java.util.Map;

public class JournalEntry {

//    properties wat JournalEntry bevat
    private Integer id;
    private String title;
    private String mood;
    private String timestamp;
    private String content;

    public JournalEntry(int id, String title, String content, String mood, String timestamp){

        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    public JournalEntry(String title, String content, String mood){

        this.title = title;
        this.content = content;
        this.mood = mood;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
