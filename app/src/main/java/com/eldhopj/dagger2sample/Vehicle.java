package com.eldhopj.dagger2sample;

import android.util.Log;

import com.eldhopj.dagger2sample.engine.Engine;
import com.eldhopj.dagger2sample.wheel.Wheels;

import javax.inject.Inject;

public class Vehicle {
    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;

    // Car shouldn't responsible for making this objects (Engine and Wheels) , it will pass into it via constructor

    //CONSTRUCTOR INJECTION
    //NOTE : can only one constructor to be annotated with @Inject
    @Inject // This will create an object for Car
    public Vehicle(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
        engine.start();
        Log.d(TAG, "driving...");
    }
}
