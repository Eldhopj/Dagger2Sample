package com.eldhopj.dagger2sample.faclitator;

import com.eldhopj.dagger2sample.MainActivity;
import com.eldhopj.dagger2sample.Vehicle;
import com.eldhopj.dagger2sample.provider.WheelsModule;
import com.eldhopj.dagger2sample.provider.engineModules.DieselEngineModule;

import javax.inject.Singleton;

import dagger.Component;

/** From here the activities get object to use */
// Component creates and stores our object and provides to us
@Component(modules = {WheelsModule.class, DieselEngineModule.class})
// dagger will put Modules into the car component, from it we get the object of wheels, tries , rims ect...
@Singleton
public interface CarComponent {
    Vehicle getCar(); // PROVISION METHODS

    void inject(MainActivity mainActivity); // For field injection
}
