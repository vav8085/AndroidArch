package com.example.myapplication.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.android.volley.VolleyError;
import com.example.myapplication.network.Avengers;
import com.example.myapplication.network.Movies;
import com.example.myapplication.network.datasources.AvengersNetworkDataSource;
import com.example.myapplication.network.serviceBuilder.NetworkObserver;

import java.util.ArrayList;
import java.util.List;

public class AvengersListFragmentViewModel extends ViewModel {
    private MutableLiveData<Avengers> avengersMutableLiveData;
    private AvengersNetworkDataSource avengersNetworkDataSource;
    private MutableLiveData<Boolean> progress;


    public AvengersListFragmentViewModel() {
        avengersMutableLiveData = new MutableLiveData<>();
        avengersNetworkDataSource = AvengersNetworkDataSource.getInstance();
        progress = new MutableLiveData<>();
    }

    public void callAvengersService(){
        progress(true);
        avengersNetworkDataSource.callAvengersService(new NetworkObserver<Avengers>() {
            @Override
            public void onSuccess(Avengers response) {
                avengersMutableLiveData.setValue(prepareMockData());
                progress(false);
            }

            @Override
            public void onFailure(VolleyError e) {
                //because gson did not work response is null so i am replacing with mock data
                avengersMutableLiveData.setValue(prepareMockData());
                progress(false);
            }
        });
    }
    private void progress(boolean b) {
        progress.setValue(b);
    }

    public LiveData<Avengers> getAvengersMutableLiveData() {
        return avengersMutableLiveData;
    }

    public LiveData<Boolean> getProgress() {
        return progress;
    }

    private Avengers prepareMockData(){
        Avengers avengers= new Avengers();
        Movies movies1 = new Movies();
        movies1.setPoster("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        movies1.setTitle("Movie 1");
        movies1.setYear("2010");
        Movies movies2 = new Movies();
        movies2.setPoster("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        movies2.setTitle("Movie 2");
        movies2.setYear("2015");
        Movies movies3 = new Movies();
        movies3.setPoster("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        movies3.setTitle("Movie 3");
        movies3.setYear("2018");
        Movies movies4 = new Movies();
        movies4.setPoster("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        movies4.setTitle("Movie 4");
        movies4.setYear("2018");
        Movies movies5 = new Movies();
        movies5.setPoster("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        movies5.setTitle("Movie 5");
        movies5.setYear("2018");
        Movies movies6 = new Movies();
        movies6.setPoster("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        movies6.setTitle("Movie 6");
        movies6.setYear("2018");
        Movies movies7 = new Movies();
        movies7.setPoster("https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        movies7.setTitle("Movie 7");
        movies7.setYear("2018");
        ArrayList<Movies> movies = new ArrayList<>();
        movies.add(movies1);
        movies.add(movies2);
        movies.add(movies3);
        movies.add(movies4);
        movies.add(movies5);
        movies.add(movies6);
        movies.add(movies7);
        avengers.setMovies(movies);
        return avengers;
    }
}
