package com.eldhopj.dagger2sample.engine;

import android.util.Log;

import com.eldhopj.dagger2sample.scope.PerActivity;

import javax.inject.Inject;

@PerActivity
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
