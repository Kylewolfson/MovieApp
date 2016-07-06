package com.epicodus.android.movieapp.services;

import android.util.Log;

import com.epicodus.android.movieapp.Constants;
import com.epicodus.android.movieapp.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject movieDBJSON = new JSONObject(jsonData);
                JSONArray moviesJSON = movieDBJSON.getJSONArray("results");
                for (int i = 0; i < moviesJSON.length(); i++) {
                    JSONObject movieJSON = moviesJSON.getJSONObject(i);
                    String name = movieJSON.getString("title");
                    String imageUrl = "https://image.tmdb.org/t/p/w300_and_h450_bestv2/" + movieJSON.optString("poster_path", "Unavailable");
                    String synopsis = movieJSON.optString("overview");
                    Movie movie = new Movie(name, synopsis, imageUrl);
                    movies.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }

        }
