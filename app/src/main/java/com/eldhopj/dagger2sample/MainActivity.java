package com.eldhopj.dagger2sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.eldhopj.dagger2sample.intermedator.CarComponent;
import com.eldhopj.dagger2sample.intermedator.DaggerCarComponent;

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
     *      When we have to create an object of interface we uses @Binds,
     *      NOTE : Bind method only take exactly one param, else use @Provides for interface also
     *
     */

    @Inject
    Car car; // Field Injection, this variable cannot be private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarComponent component = DaggerCarComponent.create(); // DaggerCarComponent contains all the necessary codes for creating the car
        //provisionMethod(component);
        fieldInjection(component);
    }

    /**
     * Field injection is for framework types, like activates and fragments where we cant make constructor
     */
    private void fieldInjection(CarComponent component) {
        //Passing our activity to the component and ask to inject the @Inject annotated field
        component.inject(this);
        car.drive();
    }

    private void provisionMethod(CarComponent component) {
        Car car;
        car = component.getCar();  // get object for car
        car.drive();
    }
}
