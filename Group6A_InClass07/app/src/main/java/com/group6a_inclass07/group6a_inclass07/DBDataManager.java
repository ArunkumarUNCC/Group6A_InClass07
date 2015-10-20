package com.group6a_inclass07.group6a_inclass07;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class DBDataManager {
    private Context context;
    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase db;
    private ITunesDAO itunesDAO;

    public DBDataManager(Context context) {
        this.context = context;
        this.openHelper = new DatabaseOpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.itunesDAO = new ITunesDAO(db) ;
    }

    public void close(){
        if (db != null){
            db.close();
        }
    }

    public ITunesDAO getNoteDAO(){
        return this.itunesDAO;
    }

    public long saveNote(ITunes note){
        return this.itunesDAO.save(note);
    }

    public boolean deleteNote(ITunes note){
        return this.itunesDAO.delete(note);
    }
}
