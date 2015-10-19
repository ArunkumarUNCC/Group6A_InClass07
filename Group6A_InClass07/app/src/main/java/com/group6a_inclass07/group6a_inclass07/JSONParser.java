package com.group6a_inclass07.group6a_inclass07;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class JSONParser {
    static final String LABEL = "label";
    static final String ATTRIBUTES = "attributes";
    static final String CURRENCY = "currency";
    static final String AMOUNT = "amount";

    public static class ParseAppFeeds{
        static ArrayList<ITunes> parseFeeds(String aStringBuilder) throws JSONException {
            ArrayList<ITunes> lFeedsArrayList = new ArrayList<ITunes>();

            JSONObject root = new JSONObject(aStringBuilder);
            JSONObject rootObject = root.getJSONObject("feed");
            JSONArray jsonEntryArray = rootObject.getJSONArray("entry");

            for (int i=0;i<jsonEntryArray.length();i++) {
                JSONObject commonObject;
                JSONArray linkArray;

                ITunes apps = new ITunes();

                //Parsing Title of the app
                commonObject = jsonEntryArray.getJSONObject(i).getJSONObject("im:name");
                apps.setAppName(commonObject.getString(LABEL));

                //Parsing Developer of the app
                commonObject = jsonEntryArray.getJSONObject(i).getJSONObject("im:artist");
                apps.setDevName(commonObject.getString(LABEL));

                //Parsing ReleaseDate of the app
                commonObject = jsonEntryArray.getJSONObject(i).getJSONObject("im:releaseDate").getJSONObject(ATTRIBUTES);
                apps.setReleaseDate(commonObject.getString(LABEL));

                //Parsing Price of the app
                commonObject = jsonEntryArray.getJSONObject(i).getJSONObject("im:price").getJSONObject(ATTRIBUTES);
                apps.setPrice(Double.parseDouble(commonObject.getString(AMOUNT)));

                //Parsing Category of the app
                commonObject = jsonEntryArray.getJSONObject(i).getJSONObject("category").getJSONObject(ATTRIBUTES);
                apps.setCategory(commonObject.getString(LABEL));

                //Parsing Image of the app
                commonObject = jsonEntryArray.getJSONObject(i);
                linkArray = commonObject.getJSONArray("im:image");
                apps.setAppImage(new String[]{linkArray.getJSONObject(0).getString(LABEL),
                        linkArray.getJSONObject(2).getString(LABEL)});

                lFeedsArrayList.add(apps);
            }

            return lFeedsArrayList;
        }
    }
}
