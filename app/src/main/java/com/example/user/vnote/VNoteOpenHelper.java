package com.example.user.vnote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class VNoteOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "VNote.db";
    public static final int DATABASE_VERSION = 1;
    public VNoteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VNoteDatabaseContract.CourseInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(VNoteDatabaseContract.NoteInfoEntry.SQL_CREATE_TABLE);

        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertCourses();
        worker.insertSampleNotes();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
