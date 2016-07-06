package com.epicodus.android.movieapp;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 7/6/16.
 */
public class MovieService {
    public static void findMovies(String searchType, String searchParam, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_BASE_URL).newBuilder();
        urlBuilder.addPathSegment(searchType);
        urlBuilder.addQueryParameter("query", searchParam);
        urlBuilder.addQueryParameter("api_key", Constants.MOVIE_DB_API_KEY);
        String url = urlBuilder.build().toString();
        Log.d("url", url);

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
