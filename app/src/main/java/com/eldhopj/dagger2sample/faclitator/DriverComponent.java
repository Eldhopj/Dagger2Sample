package com.eldhopj.dagger2sample.faclitator;

import com.eldhopj.dagger2sample.provider.DriverModule;
import com.eldhopj.dagger2sample.provider.engineModules.PetrolEngineModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {DriverModule.class})
public interface DriverComponent {
    //Driver getDriver(); SubComponent can access all the objects of parent component

    /**Child components*/
    // The child components build as an inner class in parent class
    CarComponent getCarComponent();

    ElectricCarComponent.Builder getElectricCarComponentBuilder();

    BikeComponent getBikeComponent(PetrolEngineModule petrolEngineModule);
}
