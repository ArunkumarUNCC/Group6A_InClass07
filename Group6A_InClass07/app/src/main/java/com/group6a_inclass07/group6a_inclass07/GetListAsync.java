package com.group6a_inclass07.group6a_inclass07;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class GetListAsync extends AsyncTask<String,Void,ArrayList<ITunes>>{
    IGetFeeds fActivity;
    ProgressDialog progress;
    String PROGRESSMESSAGE = "Loading Apps...";

    public GetListAsync(IGetFeeds fActivity) {
        this.fActivity = fActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progress = new ProgressDialog((Context) fActivity);
        progress.setMessage(PROGRESSMESSAGE);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
    }

    @Override
    protected ArrayList<ITunes> doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection lConnection = (HttpURLConnection) url.openConnection();
            lConnection.setRequestMethod("GET");

            lConnection.connect();

            int status = lConnection.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                BufferedReader lBufferedReader = new BufferedReader(new InputStreamReader(lConnection.getInputStream()));
                StringBuilder lStringBuilder = new StringBuilder();

                String line = lBufferedReader.readLine();

                while (line!=null){
                    lStringBuilder.append(line);
                    line = lBufferedReader.readLine();
                }

                return JSONParser.ParseAppFeeds.parseFeeds(String.valueOf(lStringBuilder));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<ITunes> appses) {
        super.onPostExecute(appses);

        progress.dismiss();
        fActivity.putList(appses);
    }

    public static interface IGetFeeds{
        public void putList(ArrayList<ITunes> feeds);
    }
}
