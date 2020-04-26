package com.eldhopj.dagger2sample.intermedator.engineModules;

import com.eldhopj.dagger2sample.engine.Engine;
import com.eldhopj.dagger2sample.engine.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
