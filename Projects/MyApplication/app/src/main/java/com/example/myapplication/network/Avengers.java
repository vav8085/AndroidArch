package com.example.myapplication.network;

import com.example.myapplication.network.serviceBuilder.MyResponse;

import java.util.ArrayList;

public class Avengers implements MyResponse {
    private ArrayList<Movies> movies;

    public ArrayList<Movies> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }
}
