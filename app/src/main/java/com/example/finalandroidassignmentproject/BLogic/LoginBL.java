package com.example.finalandroidassignmentproject.BLogic;

import android.content.Intent;

import com.example.finalandroidassignmentproject.Api_Connection;
import com.example.finalandroidassignmentproject.DoctorActivity;
import com.example.finalandroidassignmentproject.LoginActivity;
import com.example.finalandroidassignmentproject.NurseActivity;
import com.example.finalandroidassignmentproject.PatientActivity;

import java.io.IOException;

import Interface_API.USER_INTERFACE;
import model.LoginSignupResponse;
import model.USER;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginBL {

    private String email;
    private String password;
    private boolean isSuccess=false;


    public LoginBL(String email, String password){
        this.email=email;
        this.password=password;
    }


    public boolean checkUser(){
        Api_Connection api;
        api=new Api_Connection();

        Retrofit retrofit=api.getRetrofit();
        USER_INTERFACE user_interface=api.getUser_interface();

        USER user=new USER(email,password);
        Call<LoginSignupResponse>call=user_interface.loginUser(user);
        try {
            Response<LoginSignupResponse> response = call.execute();
            if (response.isSuccessful()) {
                Integer status = response.body().getStatus();
                String usertype=response.body().getUser_type();
                String token=response.body().getToken();


                if (status == 200){
                    isSuccess = true;
                }
            }
        }
            catch(IOException e){
                e.printStackTrace();
            }
            return isSuccess;
        }
    }


