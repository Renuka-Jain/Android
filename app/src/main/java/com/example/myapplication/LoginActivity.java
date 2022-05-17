package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.User;
import com.example.myapplication.models.UserData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText user = findViewById(R.id.editName);
        EditText psw = findViewById(R.id.editPassword);
        Button loginbtn = findViewById(R.id.buttonLogin);
        Button registerbtn = findViewById(R.id.buttonRegister);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = user.getText().toString();
                String password = psw.getText().toString();

                Gson gson = new GsonBuilder().setLenient().create();
                Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
                RetrofitAPI gerritAPI = retrofit.create(RetrofitAPI.class);
                Call<User> call = gerritAPI.login(new UserData(userName, null, null, password));
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        int variable = response.code();
                        Log.i("LOGIN CODE", ":"+variable);
                        if(response.isSuccessful()){
                            User user =  response.body();
                            String userNom = user.getName();
                            Log.i("Name", ":"+userNom);
                            String userPsw = user.getPass();
                            Log.i("Psw", ":"+userPsw);
                            String userMail = user.getMail();
                            Log.i("Mail", ":"+userMail);

                            Log.i("LOGIN", "OK"+user);
                            Intent intent = new Intent(getApplicationContext(), Game.class);
                            startActivity(intent);
                            SharedPreferences sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("User", userNom);
                            editor.putString("psw", userPsw);
                            editor.putString("mail", userMail);
                            editor.commit();

                            Toast.makeText(LoginActivity.this, "Usuario y password correctas", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(LoginActivity.this, "Usuario y/o password incorrectas", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e("LOGIN", "ERROR",t);
                        Toast.makeText(LoginActivity.this, "Usuario y/o password incorrectas", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
    public void buttonRegister(android.view.View v) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public void buttonFor(android.view.View v) {
        Intent intent = new Intent(this, ActivityForget.class);
        startActivity(intent);
    }
}