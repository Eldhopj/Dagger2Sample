package com.eldhopj.dagger2sample;

import dagger.Component;

/** From here the activities get object to use */
@Component // Component creates and stores our object and provides to us
public interface CarComponent {
    Car getCar(); // PROVISION METHODS
}
