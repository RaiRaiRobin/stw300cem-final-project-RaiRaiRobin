package com.example.finalandroidassignmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import model.Patients;

public class PatientList extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list2);

//        recyclerView = findViewById(R.id.recyclerView);
//
//        List<Patients> patientsList = new ArrayList<>();
//        patientsList.add(new Patients("Robin Rai","Robin@gmail.com",R.drawable.noavatar));
//
//        PatientsAdapter patientsAdapter = new PatientsAdapter(this, patientsList);
//        recyclerView.setAdapter(patientsAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
