package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.script.ScriptEngine;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText nameTxt;
    EditText surnameTxt;
    EditText mailTxt;
    EditText passTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        nameTxt = findViewById(R.id.editName);
        surnameTxt = findViewById(R.id.editSurname);
        mailTxt = findViewById(R.id.editMail);
        passTxt = findViewById(R.id.editPass);
    }




    public void buttonLOG(android.view.View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void buttonSIGN(android.view.View v) {


    }

}