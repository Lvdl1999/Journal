package com.example.journal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Onclick listener in case the user clicks on the floating button
    public void Createjournal(View view) {

        // Creating a new intent and navigating to next activity (Input Activity)
        Intent i = new Intent(MainActivity.this, InputActivity.class);
        startActivity(i);

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());

        Cursor records = db.selectAll();

        EntryAdapter entryAdapter = new EntryAdapter(MainActivity.this, R.layout.entry_row, records);

//        link aan listview in main

        ListView listView = (ListView) findViewById(R.id.listview_main);
        listView.setAdapter(entryAdapter);

    }



}

