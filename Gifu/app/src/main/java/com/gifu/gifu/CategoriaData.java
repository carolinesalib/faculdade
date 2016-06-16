package com.gifu.gifu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CategoriaData extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "categorias.db";
    private static final int DATABASE_VERSION = 1;

    public CategoriaData(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + CategoriaTable.TABLE_NAME + " (" +
                CategoriaTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriaTable.NOME + " TEXT," +
                CategoriaTable.USUARIO_ID + " INTEGER," +
                " FOREIGN KEY ("+CategoriaTable.USUARIO_ID+") REFERENCES "+UsuarioTable.TABLE_NAME+"("+UsuarioTable._ID+"));");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsuarioTable.TABLE_NAME);
        onCreate(db);
    }
}