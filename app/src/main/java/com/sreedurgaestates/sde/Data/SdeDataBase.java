package com.sreedurgaestates.sde.Data;

/**
 * Created by bbnsu_000 on 7/26/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SdeDataBase extends SQLiteOpenHelper {

    // If you change database schema, you must increment the version number
    private static final int DATABASE_VERSION = 1;

    static final String DATABSE_NAME = "sde.db";

    public SdeDataBase(Context context){
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " + "PROJECTS" + " (" +
                "_ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "COLUMN_NAME" + " TEXT NOT NULL, " +
                "COLUMN_DETAILS" + " TEXT NOT NULL, " +
                "COLUMN_SPECS" + " TEXT  NOT NULL, " +
                "COLUMN_FLOORPLAN" + " TEXT NOT NULL, " +
                "COLUMN_ROUTE" + " TEXT NOT NULL, " +
                "COLUMN_IMAGE" + " TEXT, " +
                "COLUMN_STATUS" + " TEXT NOT NULL;";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //For any upgrade, modify this method to perform the schema changes, tables changes etc.
        return;
    }


    String[] selectionArgs = new String[]{""};
    String selection = "PROJECTS" + "." + "COLUMN_STATUS" + " LIKE ?";
}
