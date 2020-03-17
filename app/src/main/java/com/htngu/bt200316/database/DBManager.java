package com.htngu.bt200316.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.htngu.bt200316.SinhVien;

import java.util.ArrayList;

public class DBManager {
    private Context context;
    private SQLHelper sqlHelper;

    public DBManager(Context context) {
        this.context = context;
        sqlHelper = new SQLHelper(context);
    }


    public void addStudent(SinhVien sinhVien) {
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(sqlHelper.NAME, sinhVien.getName());
        values.put(sqlHelper.BIRTH, sinhVien.getBirth());
        values.put(sqlHelper.SEX, sinhVien.getSex());
        values.put(sqlHelper.CHECK_SPORT, sinhVien.isCheckSport());
        values.put(sqlHelper.CHECK_TRAVEL, sinhVien.isCheckTravel());
        values.put(sqlHelper.CHECK_READBOOK, sinhVien.isCheckReadBook());

        db.insert(sqlHelper.TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList getAllStudent() {
        ArrayList<SinhVien> sinhVienArrayList = new ArrayList<>();
        String query = "SELECT * FROM " + sqlHelper.TABLE_NAME;

        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            SinhVien song = new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4) == 1, cursor.getInt(5) == 1, cursor.getInt(6) == 1);
            sinhVienArrayList.add(song);
            cursor.moveToNext();
        }
        return sinhVienArrayList;

    }

    public void deleteSV(int id) {
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
//        String query = "DELETE FROM " + sqlHelper.TABLE_NAME + " WHERE "+SQLHelper.ID+" = "+id;
////        db.rawQuery(query, null);
        db.delete(SQLHelper.TABLE_NAME, SQLHelper.ID +" = "+id, null);

    }
    public void updateSV(int id, SinhVien sinhVien) {
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(sqlHelper.NAME, sinhVien.getName());
        values.put(sqlHelper.BIRTH, sinhVien.getBirth());
        values.put(sqlHelper.SEX, sinhVien.getSex());
        values.put(sqlHelper.CHECK_SPORT, sinhVien.isCheckSport());
        values.put(sqlHelper.CHECK_TRAVEL, sinhVien.isCheckTravel());
        values.put(sqlHelper.CHECK_READBOOK, sinhVien.isCheckReadBook());

        db.update(SQLHelper.TABLE_NAME, values, SQLHelper.ID +" = "+id, null);

    }
}