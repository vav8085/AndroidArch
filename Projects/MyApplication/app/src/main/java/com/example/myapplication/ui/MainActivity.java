package com.example.myapplication.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.network.Avengers;
import com.example.myapplication.network.Movies;
import com.example.myapplication.viewModels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements Observer<Movies> {
    private MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        AvengersListFragment avengersListFragment = new AvengersListFragment();
        attachFragment(R.id.fragment_layout,avengersListFragment, AvengersListFragment.TAG);

    }

    public void attachFragment(int container, Fragment fragment, String tag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container,fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onChanged(@Nullable Movies movies) {

    }
}
