package com.eldhopj.dagger2sample.provider.engineModules;

import com.eldhopj.dagger2sample.engine.ElectricEngine;
import com.eldhopj.dagger2sample.engine.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ElectricEngineModule {

        /*NOTE : we can also use @Provides annotation like in wheels module,
             Use this when we want to bind an implementation into an interface */

    @Binds // Binds provides more performance than @Provides method
    // NOTE : @Binds methods must have exactly one parameter ( No 2 params or 0 params), whose type is assignable to the return type
    // NOTE : @Binds doesn't support any config changes, ie we cant pass value (Check PetrolEngine)
    abstract Engine bindEngine(ElectricEngine engine);
}
