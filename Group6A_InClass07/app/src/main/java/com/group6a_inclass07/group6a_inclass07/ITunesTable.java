package com.group6a_inclass07.group6a_inclass07;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class ITunesTable {
    static final String TABLE_NAME = "itunes";
    static  final String COL_ID = "_id";
    static final String COL_SUB = "subject";
    static final String COL_TEXT = "text";

    static public void onCreate(SQLiteDatabase db){
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABLE_NAME + "(");
        sb.append(COL_ID + " integer primary key autoincrement, ");
        sb.append(COL_SUB + " text not null, ");
        sb.append(COL_TEXT+ " text not null);");

        try {
            db.execSQL(sb.toString());
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    static public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
