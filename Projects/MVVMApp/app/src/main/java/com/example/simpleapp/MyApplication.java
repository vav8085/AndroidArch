package com.example.simpleapp;

import android.app.Application;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();
    public static MyApplication myApplication;
    private RequestQueue mRequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
    public static MyApplication getInstance(){
        return myApplication;
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext(), null);
        }

        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req) {
        req.setShouldCache(false);
        req.setTag(TAG);
        req.setRetryPolicy(new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(req);
    }
}
