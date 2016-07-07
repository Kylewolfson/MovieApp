package com.epicodus.android.movieapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.android.movieapp.models.Movie;
import com.epicodus.android.movieapp.ui.MovieDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 7/7/16.
 */
public class MoviePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Movie> mMovies;
    public MoviePagerAdapter(FragmentManager fm, ArrayList<Movie> movies) {
        super(fm);
        mMovies = movies;
    }

    @Override
    public Fragment getItem(int position) {
        return MovieDetailFragment.newInstance(mMovies.get(position));
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMovies.get(position).getName();
    }
}
