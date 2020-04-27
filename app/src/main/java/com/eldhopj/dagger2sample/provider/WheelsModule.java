package com.eldhopj.dagger2sample.provider;

import com.eldhopj.dagger2sample.wheel.Rims;
import com.eldhopj.dagger2sample.wheel.Tires;
import com.eldhopj.dagger2sample.wheel.Wheels;

import dagger.Module;
import dagger.Provides;

//Module class is used to create object, where we cannot use constructor injection
@Module
public abstract class WheelsModule { // NOTE : Only make abstract when every fun() are static

    @Provides //Create object rims
    //NOTE: If the this method doesn't dependent on any instance state of the module , then we can make it static for better performance
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate(); // We can do any pre-process before in using the object
        return tires;
    }


    //Like in constructor injection dagger now knows how to create object of Wheels
    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
