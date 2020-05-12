package com.example.loginsignupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {
    private EditText sName, sEmail, sPassword, sPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sName = findViewById(R.id.sName);
        sPassword = findViewById(R.id.sPassword);
        sPhone = findViewById(R.id.sPhone);
        sEmail = findViewById(R.id.sEmail);
    }

    public void signUpUser(View view) {
        ParseUser user = new ParseUser();
        user.setUsername(sName.getText().toString());
        user.setPassword(sPassword.getText().toString());
        user.setEmail(sEmail.getText().toString());

// other fields can be set just like with ParseObject
        user.put("Phone", sPhone.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    Toast.makeText(getApplicationContext(), "Registration Sucessful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openLoginActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
