package com.example.loginsignupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText lName, lPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lName = findViewById(R.id.lName);
        lPassword = findViewById(R.id.lPassword);
    }

    public void openSignupActivity(View view) {
       Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
       startActivity(intent);
    }

    public void logInUser(View view) {
        ParseUser.logInInBackground(lName.getText().toString(), lPassword.getText().toString(), new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null && e == null) {
                    Toast.makeText(getApplicationContext(), "Sucessful",Toast.LENGTH_SHORT).show();
                    openMainActivity();
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openMainActivity(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
