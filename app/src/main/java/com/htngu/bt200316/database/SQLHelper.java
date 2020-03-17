package com.htngu.bt200316.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {


    private static final String DATABASENAME = "dbname";
    private static final int VERSION = 1;

    public static final String TABLE_NAME = "svtable";
    public static final String ID = "stdid";
    public static final String NAME = "stdname";
    public static final String BIRTH = "stdbirth";
    public static final String SEX = "stdsex";
    public static final String CHECK_SPORT = "stdchecksport";
    public static final String CHECK_TRAVEL = "stdchecktravel";
    public static final String CHECK_READBOOK = "stdcheckreadbook";

    public SQLHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s INT, %s INT, %s INT)", TABLE_NAME, ID, NAME, BIRTH, SEX, CHECK_SPORT, CHECK_TRAVEL, CHECK_READBOOK);
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
