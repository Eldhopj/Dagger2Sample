package com.eldhopj.dagger2sample.intermedator.engineModules;

import com.eldhopj.dagger2sample.engine.DieselEngine;
import com.eldhopj.dagger2sample.engine.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    /*NOTE : we can also use @Provides annotation like in wheels module,
             Use this when we want to bind an implementation into an interface */

    @Binds // Binds provides more performance than @Provides method
    // NOTE : @Binds methods must have exactly one parameter ( No 2 params or 0 params), whose type is assignable to the return type
    abstract Engine bindEngine(DieselEngine engine);
}