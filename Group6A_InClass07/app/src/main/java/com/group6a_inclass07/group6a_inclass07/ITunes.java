package com.group6a_inclass07.group6a_inclass07;

import java.util.Arrays;

/**
 * Created by Arunkumar's on 10/19/2015.
 */
public class ITunes {
    String[] appImage = new String[2];
    String appName,devName,releaseDate,category;
    double price;

    public String[] getAppImage() {
        return appImage;
    }

    public void setAppImage(String[] appImage) {
        this.appImage = appImage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ITunes{" +
                "appImage=" + Arrays.toString(appImage) +
                ", appName='" + appName + '\'' +
                ", devName='" + devName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
