package com.eldhopj.dagger2sample.engine;

import android.util.Log;

import com.eldhopj.dagger2sample.scope.PerActivity;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class ElectricEngine implements Engine {
    private static final String TAG = "Car";

    private int torque;
    private int batteryCapacity;

    @Inject
    public ElectricEngine(@Named("torque") int torque,@Named("battery capacity") int batteryCapacity) {
        this.torque = torque;
        this.batteryCapacity = batteryCapacity;
    }


    @Override
    public void start() {
        Log.d(TAG, "Electric engine started with torque: "+torque+" and capacity: "+batteryCapacity);
    }
}