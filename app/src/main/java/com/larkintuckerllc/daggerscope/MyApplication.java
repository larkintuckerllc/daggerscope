package com.larkintuckerllc.daggerscope;

import android.app.Application;
import com.larkintuckerllc.daggerscope.app.AppComponent;
import com.larkintuckerllc.daggerscope.app.DaggerAppComponent;
import com.larkintuckerllc.daggerscope.auth.AuthComponent;

public class MyApplication extends Application {

   static private AppComponent sAppComponent;
   static private AuthComponent sAuthComponent;

   @Override
   public void onCreate() {
      super.onCreate();
      sAppComponent = DaggerAppComponent.create();
   }

   static public AuthComponent plusAuthComponent() {
      if (sAuthComponent == null) {
         sAuthComponent = sAppComponent.plusAuthComponent();
      }
      return sAuthComponent;
   }

   static public void clearAuthComponent() {
      sAuthComponent = null;
   }

   static public AppComponent getAppComponent() {
      return sAppComponent;
   }

   static public AuthComponent getAuthComponent() { return sAuthComponent; }

}
