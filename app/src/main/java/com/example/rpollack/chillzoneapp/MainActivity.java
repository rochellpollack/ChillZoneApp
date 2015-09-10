package com.example.rpollack.chillzoneapp;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.rpollack.chillzoneapp.Database.ChillZoneContract;
import com.example.rpollack.chillzoneapp.Database.ChillzoneDatabase;

public class MainActivity  extends ListActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

    //locations Database
    private ChillzoneDatabase chillzoneDatabase;

    private Cursor locations;

    private ListView lvLocations;

    SimpleCursorAdapter adapter;
    boolean expanded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);

        // To and from []s for adapter
        String[] from = {ChillZoneContract.LocationTable.COL_LOCATION_NAME,
                ChillZoneContract.LocationTable.COL_LOCATION_BUILDING,
                ChillZoneContract.LocationTable.COL_LOCATION_ADDRESS,
                ChillZoneContract.LocationTable.COL_LOCATION_CITY_STATE_ZIP};
        int[] to = {R.id.tvFirstLineLocationName,
                R.id.tvlocationBuilding,
                R.id.tvlocationAddress,
                R.id.tvlocationCityStateZip};


        //instantiating the database
        chillzoneDatabase = new ChillzoneDatabase(this);

        locations = this.getContentResolver().query(ChillZoneContract.LocationTable.CONTENT_URI,
                new String[]{"0 _id", ChillZoneContract.LocationTable.COL_LOCATION_ID,
                        ChillZoneContract.LocationTable.COL_LOCATION_NAME,
                        ChillZoneContract.LocationTable.COL_LOCATION_BUILDING,
                        ChillZoneContract.LocationTable.COL_LOCATION_ADDRESS,
                        ChillZoneContract.LocationTable.COL_LOCATION_CITY_STATE_ZIP},
                null,
                null,
                null);

        //converting the data from the cursor object to the listview
        adapter = new SimpleCursorAdapter(this,
                R.layout.list_item_location,
                locations,
                from,
                to);

        //set the adapter
        setListAdapter(adapter);
        // Item Click Listener for the listview
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                // Getting the Container Layout of the ListView
                LinearLayout linearLayoutParent = (LinearLayout) container;


                // Getting the Country TextView
                TextView tvLocationBuilding = (TextView) linearLayoutParent.getChildAt(2);
                TextView tvLocationAddress = (TextView) linearLayoutParent.getChildAt(3);
                TextView tvLocationCityStateZip = (TextView) linearLayoutParent.getChildAt(4);

               if(expanded == false) {

                    tvLocationBuilding.setVisibility(View.VISIBLE);
                    tvLocationAddress.setVisibility(View.VISIBLE);
                    tvLocationCityStateZip.setVisibility(View.VISIBLE);

                    expanded = true;
                }else{
                    tvLocationBuilding.setVisibility(View.GONE);
                    tvLocationAddress.setVisibility(View.GONE);
                    tvLocationCityStateZip.setVisibility(View.GONE);

                    expanded = false;
                }

            }
        };

        // Setting the item click listener for the listview
        getListView().setOnItemClickListener(itemClickListener);
        getLoaderManager().restartLoader(0, null, this);
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        locations.close();
        chillzoneDatabase.close();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, ChillZoneContract.LocationTable.CONTENT_URI,
                new String[]{"0 _id", ChillZoneContract.LocationTable.COL_LOCATION_ID,
                        ChillZoneContract.LocationTable.COL_LOCATION_NAME,
                        ChillZoneContract.LocationTable.COL_LOCATION_BUILDING,
                        ChillZoneContract.LocationTable.COL_LOCATION_ADDRESS,
                        ChillZoneContract.LocationTable.COL_LOCATION_CITY_STATE_ZIP},
                null,
                null,
                null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
       adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
       adapter.swapCursor(null);
    }
}
