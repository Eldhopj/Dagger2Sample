package com.eldhopj.dagger2sample;

import android.app.Application;

import com.eldhopj.dagger2sample.faclitator.DaggerDriverComponent;
import com.eldhopj.dagger2sample.faclitator.DriverComponent;

public class DaggerApplication extends Application {
    // Add this class into the manifest android:name=".DaggerApplication"

    private DriverComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerDriverComponent.create();
    }

    public DriverComponent getDriverComponent() {
        return component;
    }
}
