package com.eldhopj.dagger2sample.faclitator;

import com.eldhopj.dagger2sample.Driver;
import com.eldhopj.dagger2sample.provider.DriverModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {DriverModule.class})
public interface DriverComponent {
    Driver getDriver();
}
