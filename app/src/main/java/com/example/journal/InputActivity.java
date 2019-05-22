package com.example.journal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    // Onclick listener in case the user clicks on the floating button
    public void Submit(View view) {

        EditText title1 = findViewById(R.id.editText1);
        EditText content1 = findViewById(R.id.editText2);

        String title = title1.getText().toString();
        String content = content1.getText().toString();

        // Creating a new intent and navigating to next activity (Input Activity)
        Intent i = new Intent(InputActivity.this, DetailActivity.class);
        startActivity(i);

        // methode addEntry aanmaken bij onclick method

        JournalEntry journalEntry = new JournalEntry(title, content, "happy");

        // doorgeven van de journalentry object aan database

        // referentie naar database
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insertEntry(journalEntry);

    }

}
