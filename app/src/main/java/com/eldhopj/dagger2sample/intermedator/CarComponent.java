package com.eldhopj.dagger2sample.intermedator;

import com.eldhopj.dagger2sample.Car;
import com.eldhopj.dagger2sample.MainActivity;
import com.eldhopj.dagger2sample.intermedator.engineModules.DieselEngineModule;

import dagger.Component;

/** From here the activities get object to use */
// Component creates and stores our object and provides to us
@Component(modules = {WheelsModule.class, DieselEngineModule.class})
// dagger will put Modules into the car component, from it we get the object of wheels, tries , rims ect...
public interface CarComponent {
    Car getCar(); // PROVISION METHODS

    void inject(MainActivity mainActivity); // For field injection
}
