package com.eldhopj.dagger2sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.eldhopj.dagger2sample.faclitator.BikeComponent;
import com.eldhopj.dagger2sample.faclitator.CarComponent;
import com.eldhopj.dagger2sample.faclitator.DaggerBikeComponent;
import com.eldhopj.dagger2sample.faclitator.DaggerElectricCarComponent;
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
     *      Issue : Singleton annotation only works for the same component ,
     *              if we use multiple component or initialize same component multiple times it will create multiple objects
     *      Issue : It will create new objects if there is any orientation change happens
     *
     */

    @Inject
    Vehicle vehicle; // Field Injection, this variable cannot be private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CarComponent component = DaggerCarComponent.create(); // DaggerCarComponent contains all the necessary codes for creating the car
        //provisionMethod(component);
        //fieldInjection(component);
        //injectValueRuntime(125);
        valueInjectionUsingBindsInstance(50000,4000);
    }

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
    }

    private void injectValueRuntime (int cc) {
        BikeComponent component = DaggerBikeComponent.builder()
                .petrolEngineModule(new PetrolEngineModule(cc))  // Passing value while creating component
                .build();

        component.inject(this); // Field injection for getting vehicle object
        vehicle.drive();
    }

    // This is much more efficient way of passing value at runtime
    private void valueInjectionUsingBindsInstance (int batteryCap, int torque) {
        ElectricCarComponent component = DaggerElectricCarComponent.builder()
                .batteryCapacity(batteryCap)
                .torque(torque)
                .build();

        component.inject(this); // Field injection for getting vehicle object
        vehicle.drive();
    }
}
