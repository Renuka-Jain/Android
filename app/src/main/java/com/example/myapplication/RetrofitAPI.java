package com.example.myapplication;

import com.example.myapplication.models.User;
import com.example.myapplication.models.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    public static final String BASE_URL = "http://localhost:8080/dsaApp/";

    @POST("user/User")
    Call<User> login(@Body UserData user);

    @POST("user/añadir")
    Call<User> añadir(@Body UserData user);
}
