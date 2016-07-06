package com.epicodus.android.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.searchParam) EditText mSearchParam;
    @Bind(R.id.searchActorButton) Button mSearchActorButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(this);
        mSearchActorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSearchButton) {
            String searchParam = mSearchParam.getText().toString();
            Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
            intent.putExtra("searchParam", searchParam);
            intent.putExtra("searchType", "movie");
            startActivity(intent);
        }
        if(v == mSearchActorButton) {
            String searchParam = mSearchParam.getText().toString();
            Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
            intent.putExtra("searchParam", searchParam);
            intent.putExtra("searchType", "person");
            startActivity(intent);
        }
    }
}
