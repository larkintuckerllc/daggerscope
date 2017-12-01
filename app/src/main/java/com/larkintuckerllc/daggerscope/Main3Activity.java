package com.larkintuckerllc.daggerscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.larkintuckerllc.daggerscope.auth.Credentials;

import javax.inject.Inject;

public class Main3Activity extends AppCompatActivity {

    @Inject Credentials mCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getAuthComponent().inject(this);
        setContentView(R.layout.activity_main3);
        Button logoutButton = findViewById(R.id.btnLogout);
        TextView personalGreetingTextView = findViewById(R.id.tvPersonalGreeting);
        personalGreetingTextView.setText(mCredentials.getPersonalizedGreeting());
        logoutButton.setOnClickListener((v) -> {
            MyApplication.clearAuthComponent();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

    }
}
