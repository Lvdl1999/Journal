package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        JournalEntry retrievedJournalentry = (JournalEntry) intent.getSerializableExtra("journal_entry");

        TextView detailtitle = findViewById(R.id.id_title);
        TextView detaildate = findViewById(R.id.id_date);
        TextView detailmood = findViewById(R.id.id_mood);
        TextView detailcontent = findViewById(R.id.id_content);

        detaildate.setText("The date is: " + retrievedJournalentry.getTimestamp());
        detailmood.setText("My mood was: " + retrievedJournalentry.getMood());
        detailtitle.setText(retrievedJournalentry.getTitle());
        detailcontent.setText(retrievedJournalentry.getContent());

    }
}
