package com.eldhopj.dagger2sample.engine;

public interface Engine {

    /** For interface we cant make constructor*/
    //    @Inject // This will create an object for Engine
//    public Engine() {
//
//    }

    void start();
}
