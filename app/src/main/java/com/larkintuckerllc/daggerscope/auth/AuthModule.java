package com.larkintuckerllc.daggerscope.auth;

import com.larkintuckerllc.daggerscope.app.Greeting;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {

    @Provides
    @AuthScope
    static public Credentials provideCredentials(Greeting greeting) {
       return new CredentialsImpl(greeting);
    }

}
