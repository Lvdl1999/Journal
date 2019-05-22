package com.example.journal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

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

        JournalEntry journalEntry = new JournalEntry(
                cursor.getInt(cursor.getColumnIndex("_id")),
                cursor.getString(cursor.getColumnIndex("title")),
                cursor.getString(cursor.getColumnIndex("content")),
                cursor.getString(cursor.getColumnIndex("mood")),
                cursor.getString(cursor.getColumnIndex("timestamp")));


        journalEntry.setTimestamp(cursor.getString(cursor.getColumnIndex("timestamp")));

        // Detail activity
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);

        intent.putExtra("journalEntry", journalEntry);
        startActivity(intent);

        }
    }


    private class ListLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {

            ListView listView = (ListView) findViewById(R.id.listview_main);
            int position = listView.getPositionForView(view);

            EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
            db.delete(position);
            updateData();

            return false;
        }
    }

}

