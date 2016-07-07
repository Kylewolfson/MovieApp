package com.epicodus.android.movieapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.android.movieapp.R;
import com.epicodus.android.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    @Bind(R.id.movieImageView) ImageView mImageLabel;
    @Bind(R.id.movieNameTextView) TextView mNameLabel;
    @Bind(R.id.movieDateTextView) TextView mDateLabel;
    @Bind(R.id.synopsisTextView) TextView mSynopsisLabel;


    private Movie mMovie;


    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mMovie.getImageUrl()).into(mImageLabel);

        mNameLabel.setText(mMovie.getName());
        mDateLabel.setText(mMovie.getDate());
        mSynopsisLabel.setText(mMovie.getSynopsis());
        return view;
    }

}
