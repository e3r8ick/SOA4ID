package com.eguic.sportec.DataManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DataBaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "sportec.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * constructor
     *
     * @param context
     */
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Método para consultar la base de datos por estudiantes
     *
     * @param id
     * @return cursos con las datos del estudiante
     */
    public Cursor getStudent(int id) {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Filter results WHERE
        String selection = "ID" + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        String[] sqlSelect = {"NAME", "ID", "EMAIL", "HASH"};
        String sqlTable = "STUDENTS";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;
    }

    /**
     * Método para consultar la base de datos por estudiantes
     *
     * @param email
     * @return cursos con las datos del estudiante
     */
    public Cursor getStudent(String email) {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Filter results WHERE
        String selection = "EMAIL" + " = ?";
        String[] selectionArgs = {String.valueOf(email)};

        String[] sqlSelect = {"NAME", "ID", "EMAIL", "HASH"};
        String sqlTable = "STUDENTS";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, selection, selectionArgs,
                null, null, null);

        c.moveToFirst();
        return c;
    }

    /**
     * Metodo para agragar un estudiante nuevo a la base da datos
     *
     * @param name
     * @param career
     * @param id
     * @param email
     * @param hash
     * @return si se pudo hacer o no
     */
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

        Long error = db.insert(sqlTables, null, values);
        Log.d("numero de insersion", String.valueOf(error));
        if (error == -1) {
            flag = false;
        }
        return flag;

    }
}


