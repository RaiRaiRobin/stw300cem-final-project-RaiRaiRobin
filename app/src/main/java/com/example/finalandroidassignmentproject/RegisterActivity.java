package com.example.finalandroidassignmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("htto://127.0.0.1/user/register")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
