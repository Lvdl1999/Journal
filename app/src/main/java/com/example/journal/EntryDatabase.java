package com.example.journal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.icu.text.MessagePattern.ArgType.SELECT;


public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;

    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table journaltable (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, mood INTEGER, timestamp INTEGER);";
        db.execSQL(query);

        String test = "INSERT INTO journaltable (title, content, mood) VALUES('test', 'test', 'test');";
        db.execSQL(test);

    }

    // singleton concept: je mag niet bij de database maar wel vragen of er al een wasom te gebruiken en anders maakt ie nieuwe
    // public method die een variabele van type entrydatabase returnt
    public static EntryDatabase getInstance(Context context){

        // if there is no instance then create a new one called "journaldatabase"
        if (instance == null) {
            instance = new EntryDatabase(context, "journaldatabase", null, 1);
        }
        return instance;
    }

    public Cursor selectAll(){
        SQLiteDatabase database = getWritableDatabase();
        // query call dat je dit wil uitvoeren
        Cursor cursor = database.rawQuery("SELECT * FROM journaltable",null);
        return cursor;
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
