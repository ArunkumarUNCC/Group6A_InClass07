package com.group6a_inclass07.group6a_inclass07;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class ITunesTable {
    static final String TABLE_NAME = "itunes";
    static  final String COL_ID = "_id";
    static final String COL_NAME = "appName";
    static final String COL_DEV = "devName";
    static final String COL_DATE = "releaseDate";
    static final String COL_CATEGORY = "appCategory";
    static final String COL_PRICE = "appPrice";
    static final String COL_IMAGE = "appImage";

    static public void onCreate(SQLiteDatabase db){
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + TABLE_NAME + "(");
        sb.append(COL_ID + " integer primary key autoincrement, ");
        sb.append(COL_NAME + " text not null, ");
        sb.append(COL_DEV + " text not null, ");
        sb.append(COL_DATE + " text not null, ");
        sb.append(COL_CATEGORY + " text not null, ");
        sb.append(COL_PRICE + " text not null, ");
        sb.append(COL_IMAGE+ " text not null);");

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
