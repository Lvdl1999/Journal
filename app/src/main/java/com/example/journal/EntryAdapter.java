package com.example.journal;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;

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


        Integer id_index = cursor.getColumnIndex("_id");
//        opslaan in variabeles
        cursor.getInt(id_index);

        Integer title_index = cursor.getColumnIndex("title");
        cursor.getString(title_index);

        Integer mood_index = cursor.getColumnIndex("mood");
        cursor.getInt(mood_index);

        Integer timestamp_index = cursor.getColumnIndex("timestamp");
        cursor.getInt(timestamp_index);



    }
}
