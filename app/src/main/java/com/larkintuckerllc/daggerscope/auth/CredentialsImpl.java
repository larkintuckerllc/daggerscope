package com.larkintuckerllc.daggerscope.auth;

import com.larkintuckerllc.daggerscope.app.Greeting;

public class CredentialsImpl implements Credentials {

    private String mLogin;
    private Greeting mGreeting;

    CredentialsImpl(Greeting greeting) {
        mGreeting = greeting;
    }

    @Override
    public String getLogin() {
        return mLogin;
    }

    @Override
    public void setLogin(String login) {
        mLogin = login;
    }

    @Override
    public String getPersonalizedGreeting() {
        return mGreeting.getGreeting() + ' ' + mLogin;
    }

}
