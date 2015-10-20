package com.group6a_inclass07.group6a_inclass07;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public List<ITunes> getAll(){
        ArrayList<ITunes> list = new ArrayList<ITunes>();

        Cursor cursor = db.query(true, ITunesTable.TABLE_NAME, new String[]{ITunesTable.COL_ID,
                        ITunesTable.COL_NAME, ITunesTable.COL_DEV, ITunesTable.COL_PRICE},
                null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()){

            do{
                ITunes note = buildNoteFromCursor(cursor);

                if(note != null){
                    list.add(note);
                }
            }while(cursor.moveToNext());

            if(!cursor.isClosed()) {
                cursor.close();
            }
        }

        return list;
    }

    private ITunes buildNoteFromCursor(Cursor cursor){
        ITunes note = null;

        if (cursor != null){
            note = new ITunes();
            note.setAppName(cursor.getString(0));
            note.setDevName(cursor.getString(1));
            note.setPrice(cursor.getLong(2));
        }


        return note;
    }
}
