package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class InputActivity extends AppCompatActivity {

    EditText title1;
    EditText mood1;
    EditText content1;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_input);
    }

    // Onclick listener in case the user clicks on the floating button
    public void Submit(View view) {

        // Saving all input from a user when creating a new journal
        title1 = findViewById(R.id.editText1);
        content1 = findViewById(R.id.editText2);
        mood1 = findViewById(R.id.moodinput);

        String title = title1.getText().toString();
        String content = content1.getText().toString();
        String mood = mood1.getText().toString();
        Date current_time = Calendar.getInstance().getTime();
        String timestamp = String.valueOf(current_time);

        // Creating a new intent and navigating to next activity (Input Activity)
        Intent i = new Intent(InputActivity.this, DetailActivity.class);
        startActivity(i);

        JournalEntry journalEntry = new JournalEntry(0, title, content, mood, timestamp);

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insertEntry(journalEntry);

    }

    @Override
    protected void onSaveInstanceState (Bundle bundle) {

        super.onSaveInstanceState(bundle);
        bundle.putString("title", title1.getText().toString());
        bundle.putSerializable("content", content1.getText().toString());
        bundle.putString("mood", mood1.getText().toString());
    }


    // Reset the variables after rotation
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        title1.setText(savedInstanceState.getString("title"));
        content1.setText(savedInstanceState.getString("content"));
        String mood = savedInstanceState.getString("mood");
        mood1.setText(mood);

    }


}
