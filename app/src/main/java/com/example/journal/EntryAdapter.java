package com.example.journal;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, int layout, Cursor c) {
        super(context, layout, c);
    }

    @Override
    public void setDropDownViewTheme(Resources.Theme theme) {
        super.setDropDownViewTheme(theme);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor ){

        // Saving data in variables
        Integer id_index = cursor.getColumnIndex("_id");
        int idindex = cursor.getInt(id_index);

        TextView entryTitle = view.findViewById(R.id.entrytitle);
        String title = cursor.getString(cursor.getColumnIndex("title"));

        TextView entryMood = view.findViewById(R.id.entrymood);
        String mood = cursor.getString(cursor.getColumnIndex("mood"));

        TextView entryDate = view.findViewById(R.id.entrydate);
        String date = cursor.getString(cursor.getColumnIndex("timestamp"));


        // set time and date
        entryDate.setText(String.valueOf(date));
        // set title
        entryTitle.setText(title);
        // set mood
        entryMood.setText(mood);

    }
}
