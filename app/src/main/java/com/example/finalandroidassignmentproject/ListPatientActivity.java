package com.example.finalandroidassignmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Interface_API.Patient_Interface;
import adapter.PatientsAdapter;
import model.Patients;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListPatientActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Patients> list=new ArrayList<>();

    private Retrofit retrofit;
    private Patient_Interface patient_interface;
    Api_Connection api_connection;
    private PatientsAdapter adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_patient);
        recyclerView = findViewById(R.id.recyclerView);
        api_connection=new Api_Connection();
        retrofit=api_connection.getRetrofit();
        patient_interface=retrofit.create(Patient_Interface.class);

        patient_interface.getpatient();

    }

    private void getData(){
        Call<List<Patients>> data=patient_interface.getpatient();
        data.enqueue(new Callback<List<Patients>>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onResponse(Call<List<Patients>> call, Response<List<Patients>> response) {

                if (response.isSuccessful()){
                    list=response.body();
                    adap=new PatientsAdapter(ListPatientActivity.this,list);
                    LinearLayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
                    mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(adap);


                }
            }

            @Override
            public void onFailure(Call<List<Patients>> call, Throwable t) {

            }
        });
    }


}
