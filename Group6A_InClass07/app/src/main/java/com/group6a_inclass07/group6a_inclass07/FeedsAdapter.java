package com.group6a_inclass07.group6a_inclass07;

import android.content.Context;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class FeedsAdapter {
    List<ITunes> data;
    Context fContext;
    int resource;

    TextView commonTextView;

    public FeedsAdapter(List<ITunes> data, Context fContext, int resource) {
        this.data = data;
        this.fContext = fContext;
        this.resource = resource;
    }
}
