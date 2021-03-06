package com.group6a_inclass07.group6a_inclass07;
//Michael Vituli - Arunkumar Bagavathi
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import android.view.View;

import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetListAsync.IGetFeeds{

    final String APPSLINKS = "http://itunes.apple.com/us/rss/topgrossingapplications/limit=25/json";
    final static String fPREVIEW_ACTIVTY = "android.intent.action.PLAY_ACTIVITY";
    final static String fITUNE_ITEM = "Itune Item";
    ListView fITunesList;
    static FeedsAdapter fFeedsAdapter;

    ArrayList<ITunes> fList;
    DBDataManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fList = new ArrayList<ITunes>();
        fManager = new DBDataManager(this);
        fManager.deleteAllNote();
        //displaying app icon
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.inclass07_icon);

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
    public void putList(final ArrayList<ITunes> feeds) {
//        Log.d("Check ITunes",feeds.toString());
        fList = feeds;
        fFeedsAdapter = new FeedsAdapter(this,R.layout.list_view_row,feeds);
        fITunesList.setAdapter(fFeedsAdapter);
        fFeedsAdapter.setNotifyOnChange(true);

        fITunesList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                ImageView lFavoriteStar = (ImageView) view.findViewById(R.id.imageViewFavoriteStar);
//
//                //Log.d("Check click", String.valueOf(fManager.getNote(feeds.get((int) id).getAppName())));
//
//                if (fManager.getNote(feeds.get((int) id).getAppName())){
//                    lFavoriteStar.setImageDrawable(getResources().getDrawable(R.drawable.unfavorite_star));
//                    fManager.deleteNote(feeds.get((int) id));
//                }
//                else{
//                    lFavoriteStar.setImageDrawable(getResources().getDrawable(R.drawable.favorite_star));
//                    fManager.saveNote(feeds.get((int) id));
//
//                }


                return true;
            }
        });
        fITunesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(feeds.get(position));
            }
        });
    }

    public void showFavoritesOnClick(MenuItem aItem){
        fFeedsAdapter = new FeedsAdapter(this,R.layout.list_view_row,fManager.getAllNotes());
        fITunesList.setAdapter(fFeedsAdapter);
        fFeedsAdapter.setNotifyOnChange(true);


    }

    public void showAllOnClick(MenuItem aItem){
        fFeedsAdapter = new FeedsAdapter(this,R.layout.list_view_row,fList);
        fITunesList.setAdapter(fFeedsAdapter);
        fFeedsAdapter.setNotifyOnChange(true);
    }

    public void startActivity(ITunes aItuneItem){
        Intent lIntent = new Intent(fPREVIEW_ACTIVTY);
        lIntent.putExtra(fITUNE_ITEM, aItuneItem);
        this.startActivity(lIntent);
    }


}
