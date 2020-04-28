package com.eldhopj.dagger2sample.provider;

import com.eldhopj.dagger2sample.Driver;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DriverModule {

    @Provides
    static Driver provideDriver() {
        return new Driver();
    }
}
