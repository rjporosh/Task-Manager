package com.teamirregular.rjporosh.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by RjPorosh on 1/6/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="taskmanager.db";
    private static final int DATABASE_VERSION= 1;

    private static final String ID="Id";
    private static final String TITLE="Title";
    private static final String TIMESTART="Time_Start";
    private static final String TIMEEND="Time_End";
    private static final String DATE="date";

    private static String CMD="create table taskmanager("+ID+" integer primary key autoincrement, "+
            TITLE+" TEXT, "+TIMESTART+" TEXT, "+ TIMEEND+ " TEXT, "+DATE+" TEXT ) ";
    private static String UPGRADECMD="drop table taskmanager if exists";





    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UPGRADECMD);
        onCreate(db);
    }
    public void savedata(DataSource rjporosh){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues rj=new ContentValues();
        rj.put(TITLE,rjporosh.getTitle());
        rj.put(TIMESTART,rjporosh.getTimestart());
        rj.put(TIMEEND,rjporosh.getTimeend());
        rj.put(DATE,rjporosh.getDate());

        db.insert("taskmanager", null, rj);
        db.close();

    }

    public ArrayList<DataSource> retrieve(){
        SQLiteDatabase db=getWritableDatabase();
        ArrayList<DataSource> list=new ArrayList<>();
        DataSource s;
        String SQL="Select * from taskmanager";
        Cursor c =db.rawQuery(SQL,null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            s=new DataSource();
            s.setTitle(c.getString(c.getColumnIndex(TITLE)));
            s.setTimestart(c.getString(c.getColumnIndex(TIMESTART)));
            s.setTimeend(c.getString(c.getColumnIndex(TIMEEND)));
            s.setDate(c.getString(c.getColumnIndex(DATE)));
            list.add(s);
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }

}
