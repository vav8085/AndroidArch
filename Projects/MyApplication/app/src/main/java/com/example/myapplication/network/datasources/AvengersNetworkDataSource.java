package com.example.myapplication.network.datasources;

import com.example.myapplication.AvengersApplication;
import com.example.myapplication.R;
import com.example.myapplication.network.Avengers;
import com.example.myapplication.network.serviceBuilder.MyRequest;
import com.example.myapplication.network.serviceBuilder.NetworkObserver;
import com.example.myapplication.network.serviceBuilder.Repo;

import java.util.HashMap;

public class AvengersNetworkDataSource {

    public static AvengersNetworkDataSource getInstance(){
        return new AvengersNetworkDataSource();
    }
    public void callAvengersService(NetworkObserver<Avengers> networkObserver){
        Repo.newInstance()
                .setContext(AvengersApplication.getInstance())
                .setHeader(new HashMap<String, String>())
                .setObserver(networkObserver)
                .setUrl(AvengersApplication.getInstance().getString(R.string.api))
                .setMyResponseClass(Avengers.class)
                .setRequestTypeGET()
                .callService();
    }
}
