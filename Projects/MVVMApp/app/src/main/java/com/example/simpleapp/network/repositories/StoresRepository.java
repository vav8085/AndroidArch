package com.example.simpleapp.network.repositories;

import com.android.volley.VolleyError;

import com.example.simpleapp.network.serviceBuilder.MyResponse;
import com.example.simpleapp.network.serviceBuilder.NetworkObserver;
import com.example.simpleapp.network.datasources.StoresDataSource;
import com.example.simpleapp.network.datasources.StoresNetworkDataSource;

public class StoresRepository implements StoresDataSource {
    private StoresNetworkDataSource storesNetworkDataSource;
    private static StoresRepository storesRepository;
    private MyResponse data;

    private StoresRepository() {
        storesNetworkDataSource = StoresNetworkDataSource.newInstance();
    }

    public static StoresRepository getInstance() {
        if (storesRepository == null) {
            storesRepository = new StoresRepository();
        }
        return storesRepository;
    }


    @Override
    public void fetchStoreData(final NetworkObserver<MyResponse> observer) {
        if(data==null){
            storesNetworkDataSource.fetchStoreData(new NetworkObserver<MyResponse>() {
                @Override
                public void onSuccess(MyResponse response) {
                    data = response;
                    observer.onSuccess(response);
                }

                @Override
                public void onFailure(VolleyError e) {
                    observer.onFailure(e);
                }
            });
        }else{
            observer.onSuccess(data);
        }

    }
}
