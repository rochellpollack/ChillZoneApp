package com.example.rpollack.chillzoneapp.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by rpollack on 9/3/2015.
 */
public class DBOpenHelper extends SQLiteOpenHelper{

    //database version
    private static final int DB_VERSION = 1;

    //table strings
    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String COMMA = ",";
    private static final String NOT_NULL = "NOT NULL";





    //create table sentences
    private static final String CREATE_CHILLZONE_TABLE = "CREATE TABLE" +
            ChillZoneContract.ChillZoneTable.TABLE_NAME + "(" +
            ChillZoneContract.ChillZoneTable.COL_CHILLZONE_ID + INTEGER_TYPE + COMMA +
            ChillZoneContract.ChillZoneTable.COL_CHILLZONE_LOCATION_ID + INTEGER_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.ChillZoneTable.COL_CHILLZONE_DAY_OF_WEEK + TEXT_TYPE + NOT_NULL  + COMMA +
            ChillZoneContract.ChillZoneTable.COL_CHILLZONE_TIME_OF_DAY + TEXT_TYPE + NOT_NULL +  COMMA +
    ChillZoneContract.ChillZoneTable.COL_CHILLZONE_HEADCHILLER_ID + INTEGER_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.ChillZoneTable.COL_CHILLZONE_HEADCHILLER_ID_2 + INTEGER_TYPE + COMMA +
            ChillZoneContract.ChillZoneTable.COL_CHILLZONE_HEADCHILLER_ID_3 + INTEGER_TYPE + COMMA +
            ChillZoneContract.ChillZoneTable.COL_CHILLZONE_HEADCHILLER_ID_4 + INTEGER_TYPE + COMMA +
            "PRIMARY KEY" + "(" + ChillZoneContract.ChillZoneTable.COL_CHILLZONE_ID +"))";

    private static final String CREATE_LOCATION_TABLE = "CREATE TABLE" +
            ChillZoneContract.LocationTable.TABLE_NAME + "(" +
            ChillZoneContract.LocationTable.COL_LOCATION_ID + INTEGER_TYPE  +  COMMA +
            ChillZoneContract.LocationTable.COL_LOCATION_NAME + TEXT_TYPE + NOT_NULL +COMMA +
            ChillZoneContract.LocationTable.COL_LOCATION_BUILDING + TEXT_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.LocationTable.COL_LOCATION_ADDRESS + TEXT_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.LocationTable.COL_LOCATION_CITY_STATE_ZIP + TEXT_TYPE + NOT_NULL + COMMA+
            "PRIMARY KEY" + "(" + ChillZoneContract.LocationTable.COL_LOCATION_ID +"))";

    private static final String CREATE_HEAD_CHILLER_TABLE = "CREATE TABLE" +
            ChillZoneContract.HeadChillerTable.TABLE_NAME + "(" +
            ChillZoneContract.HeadChillerTable.COL_HEAD_CHILLER_ID + INTEGER_TYPE +  COMMA +
            ChillZoneContract.HeadChillerTable.COL_HEAD_CHILLER_NAME + TEXT_TYPE + NOT_NULL+ COMMA +
            ChillZoneContract.HeadChillerTable.COL_HEAD_CHILLER_PHONE_NUMBER + TEXT_TYPE + NOT_NULL+ COMMA +
            ChillZoneContract.HeadChillerTable.COL_HEAD_CHILLER_PHONE_NUMBER_2 + TEXT_TYPE + COMMA +
            ChillZoneContract.HeadChillerTable.COL_HEAD_CHILLER_EMAIL + TEXT_TYPE +NOT_NULL+ COMMA +
            "PRIMARY KEY" + "(" + ChillZoneContract.HeadChillerTable.COL_HEAD_CHILLER_ID +"))";

    private static final String CREATE_STATUS_TABLE = "CREATE TABLE" +
            ChillZoneContract.StatusTable.TABLE_NAME + "(" +
            ChillZoneContract.StatusTable.COL_STATUS_DATE + TEXT_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.StatusTable.COL_STATUS_LOCATION_ID + INTEGER_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.StatusTable.COL_STATUS_OPEN_CLOSED_DELAYED + TEXT_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.StatusTable.COL_STATUS_CHANGED_TIME + TEXT_TYPE +
            "PRIMARY KEY" + "(" + ChillZoneContract.StatusTable.COL_STATUS_DATE +
                ChillZoneContract.StatusTable.COL_STATUS_LOCATION_ID +"))";

    private static final String CREATE_CHILLERS_TABLE = "CREATE TABLE" +
            ChillZoneContract.ChillersTable.TABLE_NAME + "(" +
            ChillZoneContract.ChillersTable.COL_CHILLERS_ID + INTEGER_TYPE + "PRIMARY KEY AUTOINCREMENT" + COMMA +
            ChillZoneContract.ChillersTable.COL_CHILLERS_NAME+ TEXT_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.ChillersTable.COL_CHILLERS_LOCATION_ID + INTEGER_TYPE + NOT_NULL + ")";

    private static final String CREATE_INSTANCE_TABLE = "CREATE TABLE" +
            ChillZoneContract.InstanceTable.TABLE_NAME + "(" +
            ChillZoneContract.InstanceTable.COL_INSTANCE_ID + INTEGER_TYPE + "PRIMARY KEY AUTOINCREMENT" + COMMA +
            ChillZoneContract.InstanceTable.COL_INSTANCE_LOCATION_ID+ INTEGER_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.InstanceTable.COL_INSTANCE_DATE+ TEXT_TYPE + NOT_NULL + COMMA +
            ChillZoneContract.InstanceTable.COL_INSTANCE_CHILLER_ID + INTEGER_TYPE + NOT_NULL + ")";


    //Table delete sentences
    private static final String DROP_CHILLZONE_TABLE = "DROP TABLE IF EXIST" +
            ChillZoneContract.ChillZoneTable.TABLE_NAME;

    private static final String DROP_LOCATION_TABLE = "DROP TABLE IF EXIST" +
            ChillZoneContract.LocationTable.TABLE_NAME;

    private static final String DROP_HEAD_CHILLER_TABLE = "DROP TABLE IF EXIST" +
            ChillZoneContract.HeadChillerTable.TABLE_NAME;

    private static final String DROP_STATUS_TABLE = "DROP TABLE IF EXIST" +
            ChillZoneContract.StatusTable.TABLE_NAME;

    private static final String DROP_CHILLERS_TABLE = "DROP TABLE IF EXIST" +
            ChillZoneContract.ChillersTable.TABLE_NAME;

    private static final String DROP_INSTANCE_TABLE = "DROP TABLE IF EXIST" +
            ChillZoneContract.InstanceTable.TABLE_NAME;



    public DBOpenHelper(Context context) {
        super(context, ChillZoneContract.DATABASE_NAME, null, DB_VERSION);

    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STATUS_TABLE);
        db.execSQL(CREATE_CHILLERS_TABLE);
        db.execSQL(CREATE_INSTANCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_CHILLZONE_TABLE);
        db.execSQL(DROP_LOCATION_TABLE);
        db.execSQL(DROP_HEAD_CHILLER_TABLE);
        db.execSQL(DROP_STATUS_TABLE);
        db.execSQL(DROP_CHILLERS_TABLE);
        db.execSQL(DROP_INSTANCE_TABLE);
        onCreate(db);

    }
}
