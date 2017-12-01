package com.larkintuckerllc.daggerscope.app;

import com.larkintuckerllc.daggerscope.MainActivity;
import com.larkintuckerllc.daggerscope.auth.AuthComponent;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    AuthComponent plusAuthComponent();

    void inject(MainActivity mainActivity);

}
