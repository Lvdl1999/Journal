package com.example.journal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    EntryDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        Cursor records = db.selectAll();
        EntryAdapter entryAdapter = new EntryAdapter(MainActivity.this, R.layout.entry_row, records);

        // link aan listview in main
        ListView listView = (ListView) findViewById(R.id.listview_main);

        listView.setOnItemLongClickListener(new ListLongClickListener());
        listView.setAdapter(entryAdapter);

        listView.setOnItemClickListener(new ItemClickListener());

    }

    // Onclick listener in case the user clicks on the floating button
    public void Createjournal(View view) {

        // Creating a new intent and navigating to next activity (Input Activity)
        Intent i = new Intent(MainActivity.this, InputActivity.class);
        startActivity(i);

    }

    private void updateData() {

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();
        EntryAdapter adapter = new EntryAdapter(MainActivity.this, R.layout.entry_row, cursor);
        adapter.swapCursor(cursor);

    }

    private class ItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Retrieve item that was clicked
        Cursor cursor = (Cursor) parent.getItemAtPosition(position);

        int id_ = cursor.getInt(cursor.getColumnIndex("_id"));
        String title_= cursor.getString(cursor.getColumnIndex("title"));
        String content_ = cursor.getString(cursor.getColumnIndex("content"));
        String mood_ = cursor.getString(cursor.getColumnIndex("mood"));
        String timestamp_ = cursor.getString(cursor.getColumnIndex("timestamp"));

        JournalEntry journal = new JournalEntry(id_, title_, content_, mood_, timestamp_);

//        journal.setTimestamp(cursor.getString(cursor.getColumnIndex("timestamp")));

        // Detail activity
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);

        intent.putExtra("journal_entry", journal);

        // move to third activity
        startActivity(intent);

        }
    }


// In case an item is being long clicked
    private class ListLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

            Cursor element = (Cursor) adapterView.getItemAtPosition(position);
            EntryDatabase database = EntryDatabase.getInstance(getApplicationContext());
            database.delete(element.getInt(element.getColumnIndex("_id")));

            updateData();

            return false;
        }
    }

}

