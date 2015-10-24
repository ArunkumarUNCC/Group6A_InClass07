package com.group6a_inclass07.group6a_inclass07;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PreviewActivity extends AppCompatActivity {

    ImageView fAppIcon, fFavoriteIcon;
    TextView fAppTitle;
    final static String fITUNE_ITEM = "Itune Item";

    DBDataManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        //displaying app icon
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.inclass07_icon);

        fAppIcon = (ImageView) findViewById(R.id.imageViewAppPreview);
        fFavoriteIcon = (ImageView) findViewById(R.id.imageViewFavoriteIcon);
        fAppTitle = (TextView) findViewById(R.id.textViewAppName);

        fManager = new DBDataManager(this);

        populateData((ITunes) getIntent().getSerializableExtra(fITUNE_ITEM));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preview, menu);
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

    public void populateData(ITunes aItuneItem){

        fAppTitle.setText(aItuneItem.getAppName());
        Picasso.with(this).load(aItuneItem.getAppImage()[1]).into(fAppIcon);

        if (fManager.getNote(aItuneItem.getAppName())){

            fFavoriteIcon.setImageDrawable(getResources().getDrawable(R.drawable.favorite_star));
        }
        else{
            fFavoriteIcon.setImageDrawable(getResources().getDrawable(R.drawable.unfavorite_star));

        }
    }
}
