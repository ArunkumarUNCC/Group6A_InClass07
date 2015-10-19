package com.group6a_inclass07.group6a_inclass07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class FeedsAdapter extends ArrayAdapter<ITunes>{
    List<ITunes> data;
    Context fContext;
    int resource;

    TextView commonTextView;

    public FeedsAdapter( Context fContext, int resource, List<ITunes> data) {
        super(fContext,resource,data);
        this.data = data;
        this.fContext = fContext;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) fContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource,parent,false);
        }

        ITunes apps = data.get(position);

        //Setting Title
        commonTextView = (TextView) convertView.findViewById(R.id.textViewAppName);
        commonTextView.setText(apps.getAppName());

        //Setting Developer
        commonTextView = (TextView) convertView.findViewById(R.id.textDevName);
        commonTextView.setText(apps.getDevName());

        //Setting Release Date
        commonTextView = (TextView) convertView.findViewById(R.id.textReleaseDate);
        commonTextView.setText(apps.getReleaseDate());

        //Setting Price
        commonTextView = (TextView) convertView.findViewById(R.id.textViewPrice);
        commonTextView.setText(String.valueOf((int) apps.getPrice()) + " USD");

        //Setting Category
        commonTextView = (TextView) convertView.findViewById(R.id.textCategory);
        commonTextView.setText(apps.getCategory());

        //Setting Image
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        Picasso.with(fContext).load(apps.getAppImage()[0]).resize(100,100).into(imageView);

        return super.getView(position, convertView, parent);
    }
}
