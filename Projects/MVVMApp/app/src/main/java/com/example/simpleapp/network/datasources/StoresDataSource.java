package com.example.simpleapp.network.datasources;

import com.example.simpleapp.network.serviceBuilder.MyResponse;
import com.example.simpleapp.network.serviceBuilder.NetworkObserver;

public interface StoresDataSource {
    void fetchStoreData(NetworkObserver<MyResponse> observer);
}
