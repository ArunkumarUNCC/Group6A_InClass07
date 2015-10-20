package com.group6a_inclass07.group6a_inclass07;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class ITunesDAO {

    private SQLiteDatabase db;

    public ITunesDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long save(ITunes itunes){
        ContentValues values = new ContentValues();
        values.put(ITunesTable.COL_NAME, itunes.getAppName());
        values.put(ITunesTable.COL_DEV, itunes.getDevName());
        values.put(ITunesTable.COL_DATE, itunes.getReleaseDate());
        values.put(ITunesTable.COL_PRICE, itunes.getPrice());
        values.put(ITunesTable.COL_CATEGORY, itunes.getCategory());
        values.put(ITunesTable.COL_IMAGE, itunes.getAppImage()[0]);

        return db.insert(ITunesTable.TABLE_NAME,null,values);
    }

    public boolean delete(ITunes note){
        return db.delete(ITunesTable.TABLE_NAME, ITunesTable.COL_ID + "=?", new String[]{note.getAppName() + ""}) > 0;

    }
}
