package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
    }



}

