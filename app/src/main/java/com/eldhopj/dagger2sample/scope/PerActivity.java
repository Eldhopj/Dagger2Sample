package com.eldhopj.dagger2sample.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

// This scope lives in a lifecycle on an activity
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
