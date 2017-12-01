package com.larkintuckerllc.daggerscope.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    static Greeting provideGreeting() {
        return new GreetingImpl();
    }

}
