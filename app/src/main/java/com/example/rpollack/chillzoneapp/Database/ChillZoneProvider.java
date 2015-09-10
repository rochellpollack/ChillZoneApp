package com.example.rpollack.chillzoneapp.Database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by rpollack on 9/4/2015.
 */
public class ChillZoneProvider extends ContentProvider{

    private ChillzoneDatabase dbHelper;

    //URI matcher
    private static final int CHILLZONE = 1;
    private static final int CHILLZONE_LOCATION_STATUS = 10;
    private static final int CHILLZONE_HEADCHILLER_LOCATION = 11;

    private static final int LOCATION = 2;

    private static final int HEADCHILLER = 3;

    private static final int STATUS = 4;

    private static final int CHILLERS = 5;
    private static final int CHILLERS_INSTANCE_LOCATION = 15;

    private static final int INSTANCE = 6;

    private static final UriMatcher sURIMatcher = buildUriMatcher();
    private static UriMatcher buildUriMatcher(){
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

        final String authority = ChillZoneContract.CONTENT_AUTHORITY;

       matcher.addURI(authority, ChillZoneContract.ChillZoneTable.TABLE_NAME, CHILLZONE);
        matcher.addURI(authority, ChillZoneContract.PATH_LOCATION, LOCATION);
        matcher.addURI(authority, ChillZoneContract.HeadChillerTable.TABLE_NAME, HEADCHILLER);
        matcher.addURI(authority, ChillZoneContract.StatusTable.TABLE_NAME, STATUS);
        matcher.addURI(authority, ChillZoneContract.ChillersTable.TABLE_NAME, CHILLERS);
        matcher.addURI(authority, ChillZoneContract.InstanceTable.TABLE_NAME, INSTANCE);

        return matcher;
    }


    @Override
    public boolean onCreate() {
        // get access to the database helper
        dbHelper = new ChillzoneDatabase(getContext());
        return false;

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor retCursor;
        switch(sURIMatcher.match(uri)){
            // All Locations selected
            case LOCATION:{
                retCursor = dbHelper.getWritableDatabase().query(
                        ChillZoneContract.LocationTable.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                return retCursor;
                }

            default:{
                // By default, we assume a bad URI
                throw new UnsupportedOperationException("Unknown uri: " + uri);
                }
            }

    }

    @Override
    public String getType(Uri uri) {

        final int match = sURIMatcher.match(uri);

        switch (match){
            case CHILLZONE:{
                return ChillZoneContract.ChillZoneTable.CONTENT_DIR_TYPE;
                }
            case LOCATION:{
                return ChillZoneContract.LocationTable.CONTENT_DIR_TYPE;
                }
            case HEADCHILLER: {
                return ChillZoneContract.HeadChillerTable.CONTENT_DIR_TYPE;
            }
            case STATUS: {
                return ChillZoneContract.StatusTable.CONTENT_DIR_TYPE;
            }
            case CHILLERS: {
                return ChillZoneContract.ChillersTable.CONTENT_DIR_TYPE;
            }
            case INSTANCE: {
                return ChillZoneContract.InstanceTable.CONTENT_DIR_TYPE;
            }
            default:{
                throw new UnsupportedOperationException("Unknown uri: " + uri);
                }
            }

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
