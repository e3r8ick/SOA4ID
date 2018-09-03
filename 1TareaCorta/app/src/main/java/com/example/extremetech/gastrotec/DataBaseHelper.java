package com.example.extremetech.gastrotec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class DataBaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "gastrotec.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getStudent(int id) {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Filter results WHERE
        String selection = "ID" + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        String [] sqlSelect = {"ID", "NAME", "EMAIL", "CAREER"};
        String sqlTable = "STUDENTS";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;

    }

    public boolean addStudent(String name, String career, String id, String email, String hash) {

        Boolean flag = true;
        SQLiteDatabase db = getWritableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String sqlTables = "STUDENTS";

        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("NAME", name);
        values.put("EMAIL", email);
        values.put("CAREER", career);
        values.put("HASH", hash);

        Long error = db.insert(sqlTables,null,values);
        Log.d("numero de insersion",String.valueOf(error));
        if(error == -1){
            flag = false;
        }
        return flag;

    }
}


