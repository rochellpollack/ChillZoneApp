package com.example.rpollack.chillzoneapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.rpollack.chillzoneapp.Database.ChillZoneContract;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.Arrays;

/**
 * Created by rpollack on 9/4/2015.
 */
public class ChillzoneDatabase  extends SQLiteAssetHelper{
    //Database name
    public static final String CHILLZONE_DB = "chillzone.db";
    //Database version
    public static final int DB_VERSION = 1;

    public ChillzoneDatabase(Context context) {
        super(context, CHILLZONE_DB, null, DB_VERSION);
    }

    public Cursor getLocations() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", ChillZoneContract.LocationTable.COL_LOCATION_ID, ChillZoneContract.LocationTable.COL_LOCATION_NAME};

        String sqlTables = ChillZoneContract.LocationTable.TABLE_NAME;

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }
}
