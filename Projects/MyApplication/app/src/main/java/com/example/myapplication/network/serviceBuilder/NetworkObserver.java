package com.example.myapplication.network.serviceBuilder;

import com.android.volley.VolleyError;

public interface NetworkObserver<T> {
    void onSuccess(T response);
    void onFailure(VolleyError e);
}
