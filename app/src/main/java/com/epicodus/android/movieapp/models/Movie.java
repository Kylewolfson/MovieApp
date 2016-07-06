package com.epicodus.android.movieapp.models;

import java.util.ArrayList;

/**
 * Created by Guest on 7/6/16.
 */
public class Movie {

    private String mName;
    private String mSynopsis;
    private String mImageUrl;


    public Movie(String name, String synopsis, String imageUrl) {
        this.mName = name;
        this.mSynopsis = synopsis;
        this.mImageUrl = imageUrl;

    }

    public String getName() {
        return mName;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getImageUrl() {
        return mImageUrl;
    }


}
