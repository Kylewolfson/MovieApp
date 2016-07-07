package com.epicodus.android.movieapp.models;

import java.util.ArrayList;
import org.parceler.Parcel;

/**
 * Created by Guest on 7/6/16.
 */

@Parcel
public class Movie {

     String mName;
     String mSynopsis;
     String mDate;
     String mImageUrl;

    public Movie() {
    }

    public Movie(String name, String synopsis, String imageUrl, String date) {
        this.mName = name;
        this.mSynopsis = synopsis;
        this.mDate = date;
        this.mImageUrl = imageUrl;

    }

    public String getName() {
        return mName;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getDate() {
        return mDate;
    }

    public String getImageUrl() {
        return mImageUrl;
    }


}
