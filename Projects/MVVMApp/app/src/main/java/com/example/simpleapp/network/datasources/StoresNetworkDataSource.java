package com.example.simpleapp.network.datasources;

import com.example.simpleapp.MyApplication;

import java.util.HashMap;
import com.example.simpleapp.network.serviceBuilder.MyResponse;
import com.example.simpleapp.network.serviceBuilder.NetworkObserver;
import com.example.simpleapp.network.serviceBuilder.Repo;
import com.example.simpleapp.network.response.StoreResponse;

public class StoresNetworkDataSource implements StoresDataSource {
    private static final String URL = "";//MyApplication.getInstance().getString();
    private StoresNetworkDataSource() {}
    /**
     * This method will return a new instance of the StoreNetworkDatasource
     *
     * @return
     */
    public static StoresNetworkDataSource newInstance() {
        return new StoresNetworkDataSource();
    }

    public void fetchStoreData(NetworkObserver<MyResponse> observer){
        Repo.newInstance()
                .setContext(MyApplication.getInstance())
                .setHeader(new HashMap<String, String>())
                .setObserver(observer)
                .setUrl(URL)
                .setMyResponseClass(StoreResponse.class)
                .setRequestTypeGET()
                .callService();
    }

}
