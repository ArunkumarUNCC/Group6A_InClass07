package com.group6a_inclass07.group6a_inclass07;
//Michael Vituli - Arunkumar Bagavathi
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetListAsync.IGetFeeds{

    final String APPSLINKS = "http://itunes.apple.com/us/rss/topgrossingapplications/limit=25/json";

    ListView fITunesList;
    static FeedsAdapter fFeedsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fITunesList = (ListView) findViewById(R.id.listViewITunes);
        new GetListAsync(this).execute(APPSLINKS);
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
    public void putList(ArrayList<ITunes> feeds) {
//        Log.d("Check ITunes",feeds.toString());

//        fFeedsAdapter = new FeedsAdapter(this,R.layout.list_view_row,feeds);
    }
}
