package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void buttonRegister(android.view.View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void buttonFor(android.view.View v) {
        Intent intent = new Intent(this, ActivityForget.class);
        startActivity(intent);
    }
}