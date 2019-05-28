package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    TextView detailtitle;
    TextView detailmood;
    TextView detaildate;
    TextView detailcontent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        JournalEntry retrievedJournalentry = (JournalEntry) intent.getSerializableExtra("journal_entry");

        // Saving all textviews to change it's text
        detailtitle = findViewById(R.id.id_title);
        detaildate = findViewById(R.id.id_date);
        detailmood = findViewById(R.id.id_mood);
        detailcontent = findViewById(R.id.id_content);

        // Updating textviews
        detaildate.setText("The date was: " + retrievedJournalentry.getTimestamp());
        detailmood.setText("My mood was: " + retrievedJournalentry.getMood());
        detailtitle.setText(retrievedJournalentry.getTitle());
        detailcontent.setText(retrievedJournalentry.getContent());

    }
}
