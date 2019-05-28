package com.example.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {

//    properties wat JournalEntry bevat
    int id;
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

    // Getters

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
