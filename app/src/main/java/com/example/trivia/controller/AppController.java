package com.example.trivia.controller;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {

    private static AppController instance;
    private RequestQueue requestQueue;
//    private static Context ctx;

//    private AppController(Context context){
//        ctx = context;
//        requestQueue = getRequestQueue();
//    }

    public static synchronized AppController getInstance(){
//        if(instance == null){
//            instance = new AppController(ctx);
//        }

        return instance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
