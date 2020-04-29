package com.eldhopj.dagger2sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.eldhopj.dagger2sample.faclitator.BikeComponent;
import com.eldhopj.dagger2sample.faclitator.CarComponent;
import com.eldhopj.dagger2sample.faclitator.ElectricCarComponent;
import com.eldhopj.dagger2sample.provider.engineModules.PetrolEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    /**
     * COMPONENT - > CarComponent, PROVISION METHODS - > CarComponent , CONSTRUCTOR INJECTION -> Car
     * Field Injection :
     *      Field injection is mainly in places where we cant do constructor injection like activities, BroadcastReceivers and fragments
     * Module and Provides method :
     *      Modules and provides method is used when we cant create constructor or any think like getting object of an external libs,
     *      So we create object in Module class with the help of provides method (WheelsModule.class), and add module into Component class
     * Binds :
     *      When we have to create an object of interface (Engine.class) we uses @Binds,
     *      NOTE : Bind method (DieselEngineModule.class) only take exactly one param, else use @Provides for interface also
     *Inject value in Runtime :
     *      Most of the situation we have to inject the value at runtime (ElectricCar and Bike)
     *Singleton :
     *      We can annotate the objects with @Singleton to make it singleton
     *      but we also have to annotate @Component class also
     *      Note : if we can annotate the base class (PetrolEngine,DieselEngine...) better annotate the class,
     *              Else annotate in there @Provides method (WheelsModule)
     *      Issue 1: Singleton annotation only works for the same component ,
     *              if we use multiple component or initialize same component multiple times it will create multiple objects
     *      Issue 2: It will create new objects if there is any orientation change happens
     *CUSTOM SCOPES & COMPONENT DEPENDENCIES :
     *      The issues 2 (object creation on orientation changes)with @Singleton is fixed with this , use this for object needed through out runtime like obj of retrofit
     *               Sample : Created DriverComponent in application class
     *      Preventing creation of multiple instances in the lifecycle of an activity or a fragment
     *
     *      When we have to create a singleton just for the lifetime of an activity/fragment and also needed some other objects app wide singleton
     *              Sample : { DriverComponent :ie Driver object is app wide singleton & CarComponent : i,e the object created from CarComponent is Vehicle will only have activity level singleton}
     *              NOTE 1 :  We have to pass the dependency component ()
     *                     and On runtime value injection using Builder, we have to define the dependency in Builder also
     *SUBCOMPONENTS  : Fix the issue of NOTE 1( passing of dependency )
     *                 We can use SubComponent instead of passing dependency
     *                          SubComponent can access all the objects of parent component
     *
     */

    @Inject
    Vehicle vehicle; // Field Injection, this variable cannot be private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CarComponent component = DaggerCarComponent.create(); // DaggerCarComponent contains all the necessary codes for creating the car

        provisionMethod(getParentComponentOfCar());
        //fieldInjection(getCarComponent());
        //injectValueRuntime(125);
        valueInjectionUsingBindsInstance(50000,4000);
    }

//    private CarComponent getCarComponentPassingDependency () {
//        CarComponent component = DaggerCarComponent.builder().
//                driverComponent(((DaggerApplication) getApplication()).
//                        getDriverComponent()).build(); /** We have to pass the dependency component */
//                        return component;
//    }

    private CarComponent getParentComponentOfCar() {
        // DriverComponent is the parent component of CarComponent from there we get CarComponent
        //TIP : Class which is gonna be dependent , make it as parent and others Subcomponent
        CarComponent component = ((DaggerApplication) getApplication()).
                getDriverComponent().getCarComponent();
        return component;
    }

//    private CarComponent getCarComponent() {
//        CarComponent component = DaggerCarComponent.create(); // DaggerCarComponent contains all the necessary codes for creating the car
//        return component;
//    }

    /**
     * Field injection is for framework types, like activates and fragments where we cant make constructor
     */
    private void fieldInjection(CarComponent component) {
        //Passing our activity to the component and ask to inject the @Inject annotated field
        component.inject(this);
        vehicle.drive();
    }

    private void provisionMethod(CarComponent component) {
        Vehicle vehicle;
        vehicle = component.getCar();  // get object for vehicle
        vehicle.drive();
        vehicle.drive();
    }

    private void injectValueRuntime (int cc) { // Without using Builder

//        BikeComponent component = DaggerBikeComponent.builder()
//                .petrolEngineModule(new PetrolEngineModule(cc))  // Passing value while creating component
//                .build();

        BikeComponent component = ((DaggerApplication) getApplication()).
                getDriverComponent().getBikeComponent(new PetrolEngineModule(cc));// Passing value while creating component
        component.inject(this); // Field injection for getting vehicle object
        vehicle.drive();
    }

    // This is much more efficient way of passing value at runtime
    private void valueInjectionUsingBindsInstance (int batteryCap, int torque) {
//        ElectricCarComponent component = DaggerElectricCarComponent.builder()
//                .batteryCapacity(batteryCap)
//                .torque(torque)
//                .driverComponent(((DaggerApplication) getApplication()).getDriverComponent()) // Dependency
//                .build();

        ElectricCarComponent component = ((DaggerApplication) getApplication()).
                getDriverComponent().getElectricCarComponentBuilder()
                .batteryCapacity(batteryCap)
                .torque(torque)
                .build();

        component.inject(this); // Field injection for getting vehicle object
        vehicle.drive();
    }
}
