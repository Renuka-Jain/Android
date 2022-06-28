package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.models.Question;
import com.example.myapplication.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionActivity extends AppCompatActivity {

    EditText date;
    EditText title;
    EditText message;
    EditText sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        date = findViewById(R.id.editDate);
        title = findViewById(R.id.editTitle);
        message = findViewById(R.id.editMessage);
        sender = findViewById(R.id.editSender);

    }

    public void buttonQuestion(android.view.View v) {
        if (date.getText().toString().isEmpty() || title.getText().toString().isEmpty() || message.getText().toString().isEmpty() || sender.getText().toString().isEmpty()) {
            Toast.makeText(QuestionActivity.this, "Please enter all the values", Toast.LENGTH_SHORT).show();

            return;
        }
        else
            postPregunta(this.date.getText().toString(), this.title.getText().toString(), this.message.getText().toString(), this.sender.getText().toString());
    }

    public void postPregunta(String date, String title, String message, String sender) {

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        RetrofitAPI gerritAPI = retrofit.create(RetrofitAPI.class);
        Call<Question> call = gerritAPI.question(new Question(date, title, message, sender));
        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                int variable = response.code();
                Log.i("QUESTION CODE", ":" + variable);
                if (response.isSuccessful()) {
                    Question question = response.body();
                    String date = question.getDate();
                    Log.i("Date", ":" + date);
                    String title = question.getDate();
                    Log.i("Title", ":" + title);

                    String message = question.getMessage();
                    Log.i("Message", ":" + message);
                    String sender = question.getSender();
                    Log.i("Sender", ":" + sender);

                    Log.i("Pregunta", "OK" + question);

                    Toast.makeText(QuestionActivity.this, "Pregunta enviada correctamente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(QuestionActivity.this, "Parametros incorrectos", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.e("LOGIN", "ERROR", t);
                Toast.makeText(QuestionActivity.this, "Usuario y/o password incorrectas", Toast.LENGTH_LONG).show();
            }
        });
    }

}