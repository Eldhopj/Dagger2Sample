package com.eldhopj.dagger2sample.intermedator;

import com.eldhopj.dagger2sample.Car;
import com.eldhopj.dagger2sample.MainActivity;

import dagger.Component;

/** From here the activities get object to use */
// Component creates and stores our object and provides to us
@Component(modules = WheelsModule.class)
// dagger will put WheelsModule into the car component, from it we get the object of wheels, tries , and rims
public interface CarComponent {
    Car getCar(); // PROVISION METHODS

    void inject(MainActivity mainActivity); // For field injection
}
