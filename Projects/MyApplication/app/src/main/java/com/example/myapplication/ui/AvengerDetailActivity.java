package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.network.Movies;
import com.squareup.picasso.Picasso;

public class AvengerDetailActivity extends AppCompatActivity {
    private Movies movies;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avengers_details);
        Intent recieveIntent = getIntent();
        movies = (Movies) recieveIntent.getSerializableExtra(AvengersListFragment.AVENGERS_DETAILS);
        ImageView image = findViewById(R.id.image_movie_detail);
        TextView heading = findViewById(R.id.text_movie_detail_heading);
        Picasso.get().load(movies.getPoster()).fit().into(image);
        heading.setText(movies.getTitle());
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
