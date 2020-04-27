package com.eldhopj.dagger2sample.provider.engineModules;

import com.eldhopj.dagger2sample.engine.Engine;
import com.eldhopj.dagger2sample.engine.PetrolEngine;

import dagger.Module;
import dagger.Provides;

@Module
public  class PetrolEngineModule {

    private int cubicCentimeters;

    public PetrolEngineModule(int cubicCentimeters) { // Constructor to get value into Module
        this.cubicCentimeters = cubicCentimeters;
    }

    @Provides
     Engine providesEngine (){
        return new PetrolEngine(cubicCentimeters); // passing value into petrol engine
    }
}
