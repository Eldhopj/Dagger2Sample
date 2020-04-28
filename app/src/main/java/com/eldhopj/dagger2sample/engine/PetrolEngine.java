package com.eldhopj.dagger2sample.engine;

import android.util.Log;

import com.eldhopj.dagger2sample.scope.PerActivity;

import javax.inject.Inject;

@PerActivity
public class PetrolEngine implements Engine{
    private static final String TAG = "Car";

    private int cubicCentimeters;

    @Inject
    public PetrolEngine(int cubicCentimeters) { //accepting value in runtime from the Module class
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public void start() {
        Log.d(TAG, "Petrol engine started with cc : "+  cubicCentimeters);
    }
}
