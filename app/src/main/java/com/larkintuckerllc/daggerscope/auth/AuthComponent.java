package com.larkintuckerllc.daggerscope.auth;

import com.larkintuckerllc.daggerscope.Main2Activity;
import com.larkintuckerllc.daggerscope.Main3Activity;

import dagger.Subcomponent;

@Subcomponent(modules = AuthModule.class)
@AuthScope
public interface AuthComponent {

    void inject(Main2Activity main2Activity);

    void inject(Main3Activity main3Activity);

    Credentials getCredentials();

}
