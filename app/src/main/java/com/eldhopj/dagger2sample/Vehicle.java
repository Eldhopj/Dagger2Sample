package com.eldhopj.dagger2sample;

import android.util.Log;

import com.eldhopj.dagger2sample.engine.Engine;
import com.eldhopj.dagger2sample.scope.PerActivity;
import com.eldhopj.dagger2sample.wheel.Wheels;

import javax.inject.Inject;

@PerActivity // Create single instance of the vehicle with in the same component
public class Vehicle {
    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;
    private Driver driver;

    // Car shouldn't responsible for making this objects (Engine and Wheels) , it will pass into it via constructor

    //CONSTRUCTOR INJECTION
    //NOTE : can only one constructor to be annotated with @Inject
    @Inject // This will create an object for Car, and what all necessary objects need are define here
    public Vehicle(Engine engine, Wheels wheels, Driver driver) {
        this.engine = engine;
        this.wheels = wheels;
        this.driver = driver;
    }

    public void drive() {
        driver.enter();
        engine.start();
        Log.d(TAG, "driving... "+this);
    }
}
