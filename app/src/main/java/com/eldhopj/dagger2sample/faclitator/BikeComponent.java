package com.eldhopj.dagger2sample.faclitator;

import com.eldhopj.dagger2sample.MainActivity;
import com.eldhopj.dagger2sample.provider.WheelsModule;
import com.eldhopj.dagger2sample.provider.engineModules.PetrolEngineModule;
import com.eldhopj.dagger2sample.scope.PerActivity;

import dagger.Subcomponent;

/** From here the activities get object to use */
// Component creates and stores our object and provides to us
    //Dependencies : getting objects from other components
//@Component(dependencies = DriverComponent.class, modules = {WheelsModule.class, PetrolEngineModule.class})
// dagger will put Modules into the bike component, from it we get the object of wheels, tries , rims ect...
@PerActivity

@Subcomponent(modules = {WheelsModule.class, PetrolEngineModule.class}) // Subcomponent can access everything of the parent component (DriverComponent)

public interface BikeComponent {

    void inject(MainActivity mainActivity); // For field injection
}
