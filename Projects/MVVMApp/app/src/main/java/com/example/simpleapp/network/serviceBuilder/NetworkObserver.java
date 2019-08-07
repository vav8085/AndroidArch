package com.example.simpleapp.network.serviceBuilder;

import com.android.volley.VolleyError;

public interface NetworkObserver<T> {
    void onSuccess(T response);
    void onFailure(VolleyError e);
}
