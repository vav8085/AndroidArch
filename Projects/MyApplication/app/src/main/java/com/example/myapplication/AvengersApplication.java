package com.example.myapplication;

import android.app.Application;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AvengersApplication extends Application {
    private static AvengersApplication avengersApplication;
    public static final String TAG = AvengersApplication.class.getSimpleName();
    private RequestQueue mRequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        avengersApplication = this;
    }
    public static AvengersApplication getInstance(){
        return avengersApplication;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setShouldCache(false);
        req.setTag(TAG);
        req.setRetryPolicy(new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(req);
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext(), null);
        }

        return mRequestQueue;
    }
}
