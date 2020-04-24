package com.eldhopj.dagger2sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    /**Commit 1 :  COMPONENT - > CarComponent, PROVISION METHODS - > CarComponent , CONSTRUCTOR INJECTION -> Car*/

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
