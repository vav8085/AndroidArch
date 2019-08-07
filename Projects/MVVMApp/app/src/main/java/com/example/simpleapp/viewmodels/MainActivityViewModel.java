package com.example.simpleapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.VolleyError;
import com.example.simpleapp.network.repositories.StoresRepository;
import com.example.simpleapp.network.response.Store;
import com.example.simpleapp.network.response.StoreResponse;
import com.example.simpleapp.network.serviceBuilder.MyResponse;
import com.example.simpleapp.network.serviceBuilder.NetworkObserver;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private StoresRepository storesRepository;
    private MutableLiveData<List<Store>> storeMutableLiveData;
    private MutableLiveData<Boolean> progressBarMutableLiveData;
    public MainActivityViewModel(){
        storesRepository = StoresRepository.getInstance();
        storeMutableLiveData = new MutableLiveData<>();
        progressBarMutableLiveData = new MutableLiveData<>();
    }

    public void fetchStoreData(){
        progressBarMutableLiveData.setValue(true);
        storesRepository.fetchStoreData(new NetworkObserver<MyResponse>() {
            @Override
            public void onSuccess(MyResponse response) {
                StoreResponse storeResponse = (StoreResponse)response;
                storeMutableLiveData.setValue(storeResponse.getStores());
                progressBarMutableLiveData.setValue(false);
            }

            @Override
            public void onFailure(VolleyError e) {
                progressBarMutableLiveData.setValue(false);
            }
        });
    }

    public LiveData<List<Store>> getStoreMutableLiveData() {
        return storeMutableLiveData;
    }

    public LiveData<Boolean> getProgressBarMutableLiveData() {
        return progressBarMutableLiveData;
    }
}
