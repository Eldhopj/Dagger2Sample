package com.eldhopj.dagger2sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /**Commit 1 :  COMPONENT - > CarComponent, PROVISION METHODS - > CarComponent , CONSTRUCTOR INJECTION -> Car*/
    private Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.create(); // DaggerCarComponent contains all the necessary codes for creating the car

        car = component.getCar();  // get object for car
        car.drive();
    }
}
