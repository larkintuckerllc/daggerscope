package com.larkintuckerllc.daggerscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.larkintuckerllc.daggerscope.auth.Credentials;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {

    @Inject Credentials mCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getAuthComponent().inject(this);
        setContentView(R.layout.activity_main2);
        Button logoutButton = findViewById(R.id.btnLogout);
        Button nextButton = findViewById(R.id.btnNext);
        TextView loginTextView = findViewById(R.id.tvLogin);
        loginTextView.setText(mCredentials.getLogin());
        logoutButton.setOnClickListener((v) -> {
            MyApplication.clearAuthComponent();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        nextButton.setOnClickListener((v) -> {
            startActivity(new Intent(this, Main3Activity.class));
            finish();
        });
    }

}
