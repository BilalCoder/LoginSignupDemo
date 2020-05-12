package com.example.loginsignupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    private TextView helo;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helo = findViewById(R.id.helo);
    }
    public void heloClicked(View view){
        ParseUser.logOut();
        finish();
        Toast.makeText(getApplicationContext(), "Close the app to log out", Toast.LENGTH_SHORT).show();
    }
}
