package com.example.contentprovidertest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FunkoPop.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MY_DATA_TABLE = "CREATE TABLE " + MyDataContract.MyDataEntry.TABLE_NAME + " (" +
                MyDataContract.MyDataEntry._ID + " INTEGER PRIMARY KEY, " +
                MyDataContract.MyDataEntry.POP_NAME + " TEXT NOT NULL, " +
                MyDataContract.MyDataEntry.POP_NUMBER + " INTEGER NOT NULL, " +
                MyDataContract.MyDataEntry.POP_TYPE + " TEXT, " +
                MyDataContract.MyDataEntry.FANDOM + " TEXT, " +
                MyDataContract.MyDataEntry.ON + " INTEGER, " +
                MyDataContract.MyDataEntry.ULTIMATE + " TEXT, " +
                MyDataContract.MyDataEntry.PRICE + " REAL NOT NULL);";

        db.execSQL(SQL_CREATE_MY_DATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades here
    }
}
