package com.example.rpollack.chillzoneapp.Database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;

/**
 * Created by rpollack on 9/3/2015.
 */
public class ChillZoneContract {

    //Content Authority

    public static final String CONTENT_AUTHORITY = "com.example.rpollack.chillzoneapp";
    //base for all uris
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    // Possible paths (appended to base content URI for possible URI's)
    public static final String PATH_CHILLZONE = "chillzone";
    public static final String PATH_LOCATION = "Location";
    public static final String PATH_HEADCHILLER = "headchiller";
    public static final String PATH_STATUS = "status";
    public static final String PATH_CHILLERS = "chillers";
    public static final String PATH_INSTANCE = "instance";

    //Database Name
    public static final String DATABASE_NAME = "databases/chillzone.db";


    //chillzone table
    public static final class ChillZoneTable{

        //table name
        public static final String TABLE_NAME = "Chillzone";

        //table fields
        public static final String COL_CHILLZONE_ID = "chillzone_id";
        public static final String COL_CHILLZONE_GENDER = "chillzone_gender";
        public static final String COL_CHILLZONE_LOCATION_ID = "chillzone_location_id";
        public static final String COL_CHILLZONE_DAY_OF_WEEK = "chillzone_day_of_week";
        public static final String COL_CHILLZONE_TIME_OF_DAY = "chillzone_time_of_day";
        public static final String COL_CHILLZONE_HEADCHILLER_ID = "chillzone_headchiller_id";
        public static final String COL_CHILLZONE_HEADCHILLER_ID_2 = "chillzone_headchiller_id_2";
        public static final String COL_CHILLZONE_HEADCHILLER_ID_3 = "chillzone_headchiller_id_3";
        public static final String COL_CHILLZONE_HEADCHILLER_ID_4 = "chillzone_headchiller_id_4";

        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
          			ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;



        }

    //location table
    public static final class LocationTable{

        //table name
        public static final String TABLE_NAME = "Location";

        //table fields
        public static final String COL_LOCATION_ID = "location_id";
        public static final String COL_LOCATION_NAME = "location_name";
        public static final String COL_LOCATION_BUILDING = "location_building";
        public static final String COL_LOCATION_ADDRESS = "location_address";
        public static final String COL_LOCATION_CITY_STATE_ZIP= "location_city_state_zip";

        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;




    }

    //head chiller table
    public final static class HeadChillerTable{

        //table name
        public static final String TABLE_NAME = "Head_Chiller";

        //table fields
        public static final String COL_HEAD_CHILLER_ID = "head_chiller_id";
        public static final String COL_HEAD_CHILLER_NAME = "head_chiller_name";
        public static final String COL_HEAD_CHILLER_PHONE_NUMBER = "head_chiller_phone_number";
        public static final String COL_HEAD_CHILLER_PHONE_NUMBER_2 = "head_chiller_phone_number_2";
        public static final String COL_HEAD_CHILLER_EMAIL= "head_chiller_email";

        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;



    }

    //status table
    public final static class StatusTable{

        //table name
        public static final String TABLE_NAME = "Status";

        //table fields
        public static final String COL_STATUS_DATE = "status_date";
        public static final String COL_STATUS_LOCATION_ID = "status_location_id";
        public static final String COL_STATUS_OPEN_CLOSED_DELAYED = "status_open_closed_delayed";
        public static final String COL_STATUS_CHANGED_TIME = "status_changed_time";

        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;



    }

    //chillers table
    public static final class ChillersTable{

        //table name
        public static final String TABLE_NAME = "Chillers";

        //table fields
        public static final String COL_CHILLERS_ID = "chillers_id";
        public static final String COL_CHILLERS_NAME = "chillers_name";
        public static final String COL_CHILLERS_LOCATION_ID = "chillers_location_id";

        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;



    }

    //instance table
    public final static   class InstanceTable{

        //table name
        public static final String TABLE_NAME = "Instance";

        //table fields
        public static final String COL_INSTANCE_ID = "instance_id";
        public static final String COL_INSTANCE_LOCATION_ID = "instance_location_id";
        public static final String COL_INSTANCE_DATE = "instance_date";
        public static final String COL_INSTANCE_CHILLER_ID = "instance_chiller_id";

        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;



    }


}
