package com.eldhopj.dagger2sample.engine;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DieselEngine implements Engine {
    private static final String TAG = "Car";

    @Inject
    public DieselEngine() {

    }

    @Override
    public void start() {
        Log.d(TAG, "Diesel engine started");
    }
}
