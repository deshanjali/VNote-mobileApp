package com.example.user.vnote;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertCourses() {
        insertCourse("android_basics", "Android Basics");
        insertCourse("android_UI", "Android UI settings");
        insertCourse("android_adv.concepts", "Advanced Concepts");
        insertCourse("java_core", "Java Fundamentals");
    }

    public void insertSampleNotes() {
        insertNote("android_basics", "Activities", "Android system initiates its program with in an Activity starting with a call on onCreate() callback method.");
        insertNote("android_basics", "Intents", "An Android Intent is an abstract description of an operation to be performed.");

        insertNote("android_UI", "UI Layouts", "View is the base class for widgets, which are used to create interactive UI components like buttons, text fields, etc.");
        insertNote("android_UI", "UI Controls", "Android provides a wide variety of controls you can use in your UI, such as buttons, text fields, seek bars, etc.");

        insertNote("android_adv.concepts", "Location Based Services", "The Location object represents a geographic location which can consist of a latitude, longitude, time stamp, and other information such as bearing, altitude and velocity.");
        insertNote("android_adv.concepts", "Notifications", "A notification is a message you can display to the user outside of your application's normal UI.");

        insertNote("java_core", "Variables", "A variable is a container which holds the value while the java program is executed. A variable is assigned with a data type.");
        insertNote("java_core", "Classes/Objects", "A class can be defined as a template/blueprint that describes the behavior/state that the object of its type support.");
    }

    private void insertCourse(String courseId, String title) {
        ContentValues values = new ContentValues();
        values.put(VNoteDatabaseContract.CourseInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(VNoteDatabaseContract.CourseInfoEntry.COLUMN_COURSE_TITLE, title);

        long newRowId = mDb.insert(VNoteDatabaseContract.CourseInfoEntry.TABLE_NAME, null, values);
    }

     private void insertNote(String courseId, String title, String text) {
        ContentValues values = new ContentValues();
        values.put(VNoteDatabaseContract.NoteInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(VNoteDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TITLE, title);
        values.put(VNoteDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TEXT, text);

        long newRowId = mDb.insert(VNoteDatabaseContract.NoteInfoEntry.TABLE_NAME, null, values);
    }

}
