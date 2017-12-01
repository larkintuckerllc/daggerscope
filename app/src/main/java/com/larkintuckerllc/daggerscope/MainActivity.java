package com.larkintuckerllc.daggerscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.larkintuckerllc.daggerscope.app.Greeting;
import com.larkintuckerllc.daggerscope.auth.Credentials;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject Greeting mGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        EditText loginEditText = findViewById(R.id.etLogin);
        Button loginButton = findViewById(R.id.btnLogin);
        TextView greetingTextView = findViewById(R.id.tvGreeting);
        greetingTextView.setText(mGreeting.getGreeting());
        loginButton.setOnClickListener((v) -> {
            String login = loginEditText.getText().toString().trim();
            if (login.matches("")) {
                return;
            }
            Credentials credentials = MyApplication
                .plusAuthComponent()
                .getCredentials();
            credentials.setLogin(login);
            startActivity(new Intent(this, Main2Activity.class));
        });
    }

}
