package com.eldhopj.dagger2sample;

import android.util.Log;

public class Driver {
    //we don't own this class so we can't annotate it with @Inject

//    @Inject
//    public Driver() {
//    }

    private static final String TAG = "Car";

    public void enter() {
        Log.d(TAG, "Driver"+ this+" Entered");
    }
}
