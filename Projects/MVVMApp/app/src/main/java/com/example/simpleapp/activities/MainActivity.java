package com.example.simpleapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.simpleapp.R;
import com.example.simpleapp.databinding.ActivityMainBinding;
import com.example.simpleapp.network.recyclerview.MainRecyclerviewAdapter;
import com.example.simpleapp.network.response.Store;
import com.example.simpleapp.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.fetchStoreData();
        attachObservers();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainRecyclerviewAdapter adapter = new MainRecyclerviewAdapter(this, new ArrayList<Store>());
        recyclerView.setAdapter(adapter);
    }

    private void attachObservers() {
        mainActivityViewModel.getProgressBarMutableLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                
            }
        });
        mainActivityViewModel.getStoreMutableLiveData().observe(this, new Observer<List<Store>>() {
            @Override
            public void onChanged(List<Store> stores) {

            }
        });
    }
}
