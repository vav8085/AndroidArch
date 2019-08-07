package com.example.myapplication.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.myapplication.R;
import com.example.myapplication.network.Avengers;
import com.example.myapplication.network.Movies;
import com.example.myapplication.viewModels.AvengersListFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class AvengersListFragment extends Fragment implements com.example.myapplication.network.listeners.Observer {
    public static final String TAG = AvengersListFragment.class.getSimpleName();
    public static final String AVENGERS_DETAILS = "avengers_details";
    private AvengersListFragmentViewModel viewModel;
    private RecyclerView recyclerView;
    private AvengersListAdapter adapter;
    private ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(AvengersListFragmentViewModel.class);
        View rootView = inflater.inflate(R.layout.fragment_avengers, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        progressBar = rootView.findViewById(R.id.progressBar2);
        setRetainInstance(true);
        attachObservers();
        viewModel.callAvengersService();
        return rootView;
    }

    private void attachObservers() {
        viewModel.getAvengersMutableLiveData().observe(this, new Observer<Avengers>() {
            @Override
            public void onChanged(@Nullable Avengers avengers) {
                setupRecyclerView(avengers.getMovies());
            }
        });
        viewModel.getProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean)
                    progressBar.setVisibility(View.VISIBLE);
                else
                    progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setupRecyclerView(ArrayList<Movies> movies) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AvengersListAdapter(movies,getContext(),AvengersListFragment.this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onClick(Movies movies) {
        Intent intent = new Intent(getActivity(),AvengerDetailActivity.class);
        intent.putExtra(AVENGERS_DETAILS,movies);
        startActivity(intent);
    }
}
