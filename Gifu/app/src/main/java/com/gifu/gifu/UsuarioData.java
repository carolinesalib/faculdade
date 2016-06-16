package com.gifu.gifu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioData extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    public UsuarioData(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UsuarioTable.TABLE_NAME + " (" +
                UsuarioTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UsuarioTable.NOME + " TEXT," +
                UsuarioTable.TOKEN + " TEXT," +
                UsuarioTable.EMAIL + " TEXT," +
                UsuarioTable.SENHA + " TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsuarioTable.TABLE_NAME);
        onCreate(db);
    }
}