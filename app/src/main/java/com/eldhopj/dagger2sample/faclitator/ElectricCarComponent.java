package com.eldhopj.dagger2sample.faclitator;

import com.eldhopj.dagger2sample.MainActivity;
import com.eldhopj.dagger2sample.provider.WheelsModule;
import com.eldhopj.dagger2sample.provider.engineModules.ElectricEngineModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;


/** From here the activities get object to use */
// Component creates and stores our object and provides to us
@Singleton
@Component(modules = {WheelsModule.class, ElectricEngineModule.class})
// dagger will put Modules into the bike component, from it we get the object of wheels, tries , rims ect...

public interface ElectricCarComponent {

    void inject(MainActivity mainActivity); // For field injection

    // We are defining api's for put Electric car component
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder torque(@Named("torque") int torque);

        @BindsInstance
        Builder batteryCapacity(@Named("battery capacity") int batteryCapacity);

        ElectricCarComponent build();
    }
}
