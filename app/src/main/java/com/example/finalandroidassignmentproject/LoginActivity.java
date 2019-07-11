package com.example.finalandroidassignmentproject;

import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Interface_API.USER_INTERFACE;
import model.LoginSignupResponse;
import model.USER;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail, etPassword;
    private TextView register;
    Button btnLogin;

    private USER_INTERFACE user_interface;
    private Retrofit retrofit;
    private Api_Connection api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        api=new Api_Connection();
        getConnection();


    }


    private void  getConnection(){
        retrofit=api.getRetrofit();
        user_interface=api.getUser_interface();
    }
    private void init(){
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        register=findViewById(R.id.register);
        btnLogin.setOnClickListener(this);
        register.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnLogin){

//            if (AuthenticateUser(etEmail.getText().toString(),etPassword.getText().toString())){
//
//                startActivity(new Intent(LoginActivity.this,NurseActivity.class));
//                finish();
//
//            }
//            else{
//                Toast.makeText(LoginActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
//            }
//        checkUser(etEmail.getText().toString(),etPassword.getText().toString());
            AuthenticateUser(etEmail.getText().toString(),etPassword.getText().toString());
        }

        if (v.getId()==R.id.register) {
        startActivity(new Intent(LoginActivity.this,Register.class));

        }


    }

//    private void StrictMode(){
//
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//
//        StrictMode.setThreadPolicy(policy);
//    }

//    private void checkUser(String username,String password){
//        StrictMode();
//        LoginBL loginBL=new LoginBL(username,password);
//        if (loginBL.checkUser()){
//            String usertype=response.body().getUser_type();
//            Integer status = response.body().getStatus();
//
//            if ()
//
//            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//        }
//    }

    private void AuthenticateUser(String email, String password) {
        USER user=new USER(email,password);
        Call<LoginSignupResponse> call=user_interface.loginUser(user);
        call.enqueue(new Callback<LoginSignupResponse>() {
            @Override
            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                }
                else{

                    String usertype=response.body().getUser_type();
                    Integer status = response.body().getStatus();
                    String token=response.body().getToken();
                    String message=response.body().getMessage();
                    String gender=response.body().getGender();
                    String email=response.body().getEmail();
                    String fname=response.body().getFname();
                    String mname=response.body().getMname();
                    String lname=response.body().getLname();
                    String photo=response.body().getPhoto();

                    SharedPreferences sharedPreferences=getSharedPreferences("Token",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();

                    editor.putString("token",token);
                    editor.commit();
                    if (status == 200){

                        startActivity(new Intent(LoginActivity.this,NurseActivity.class));


//                        if (usertype.equals("nurse")){
////                            Toast.makeText(LoginActivity.this, photo, Toast.LENGTH_SHORT).show();
////                            startActivity(new Intent(LoginActivity.this,NurseActivity.class));
//                            Intent intent=new Intent(LoginActivity.this,NurseActivity.class);
//                            intent.putExtra("email",email);
//                            intent.putExtra("fname",fname);
//                            intent.putExtra("mname",mname);
//                            intent.putExtra("lname",lname);
//                            intent.putExtra("photo",photo);
//
//                            startActivity(intent);
//
//
//                        }else if (usertype.equals("doctor")){
//                            startActivity(new Intent(LoginActivity.this,DoctorActivity.class));
//
//                        }
//                        else{
////                            Toast.makeText(LoginActivity.this, gender, Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(LoginActivity.this,PatientActivity.class));
//                        }

                    }
                    else{
                        Toast.makeText(LoginActivity.this, "PLEASE CONNECT", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
