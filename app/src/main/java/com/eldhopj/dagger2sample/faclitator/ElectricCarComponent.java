package com.eldhopj.dagger2sample.faclitator;

import com.eldhopj.dagger2sample.MainActivity;
import com.eldhopj.dagger2sample.provider.WheelsModule;
import com.eldhopj.dagger2sample.provider.engineModules.ElectricEngineModule;
import com.eldhopj.dagger2sample.scope.PerActivity;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;


/** From here the activities get object to use */
// Component creates and stores our object and provides to us
@PerActivity
// Component creates and stores our object and provides to us
@Component(dependencies = DriverComponent.class, modules = {WheelsModule.class, ElectricEngineModule.class})
// dagger will put Modules into the bike component, from it we get the object of wheels, tries , rims ect...

public interface ElectricCarComponent {

    void inject(MainActivity mainActivity); // For field injection

    // We are defining api's for put Electric car component
    //NOTE : if there is any dependencies when we using Builder method its mandatory to define the dependency in Builder
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder torque(@Named("torque") int torque);

        @BindsInstance
        Builder batteryCapacity(@Named("battery capacity") int batteryCapacity);

        Builder driverComponent(DriverComponent component); // dependency

        ElectricCarComponent build();
    }
}
