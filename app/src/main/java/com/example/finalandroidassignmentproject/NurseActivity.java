package com.example.finalandroidassignmentproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import Interface_API.USER_INTERFACE;
import broadcast.BroadcastReceiver;

public class NurseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    CarouselView carouselView;
    private DrawerLayout drawer;
    private ImageView ivProfile;
    private TextView TvRLight,TvLight;
    private CardView first;
    private CardView Second;

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver(this);


    private USER_INTERFACE user_interface;

    int[] sampleImages={R.drawable.one,R.drawable.twobg,R.drawable.threeback};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nurse);
        TvLight = (TextView)findViewById(R.id.TvLight);
        TvRLight = (TextView)findViewById(R.id.TvRLight);



        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        first = findViewById(R.id.first);
        Second = findViewById(R.id.Second);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NurseActivity.this,ListPatientActivity.class);
                startActivity(intent);
            }
        });
        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NurseActivity.this,ListPatientActivity.class);
                startActivity(intent);
            }
        });

        Sensor lightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(lightSensor != null){
            TvLight.setText("Sensor.TYPE_LIGHT Available");
            mySensorManager.registerListener(
                    lightSensorListener,
                    lightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        } else {
            TvRLight.setText("Sensor.TYPE_LIGHT NOT Available");
        }





        NavigationView navigationView=(NavigationView) findViewById(R.id.navigationView);
        View headerView=navigationView.getHeaderView(0);
        TextView navEmail=(TextView) headerView.findViewById(R.id.tvtEmail);


        NavigationView navigationView1=(NavigationView) findViewById(R.id.navigationView);
        View headerView1=navigationView1.getHeaderView(0);
        TextView navFullname=(TextView) headerView.findViewById(R.id.tvFullname);


        NavigationView navigationView2=(NavigationView) findViewById(R.id.navigationView);
        View headerView2=navigationView2.getHeaderView(0);
        ImageView ivProfile=(ImageView) headerView2.findViewById(R.id.ivProfile);




        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String email=bundle.getString("email");
            String fname=bundle.getString("fname");
            String mname=bundle.getString("mname");
            String lname=bundle.getString("lname");
            String photo=bundle.getString("photo");

            String fullname=fname+" "+mname+" "+lname;

            Toast.makeText(this, email+" Hello", Toast.LENGTH_SHORT).show();
            navEmail.setText(email);
            Toast.makeText(this, email+" There", Toast.LENGTH_SHORT).show();
            navFullname.setText(fullname);
//            loadFromURL();
        }







        carouselView= findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView3= findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    private void StrictMode(){
        android.os.StrictMode.ThreadPolicy policy=new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }

    private void loadFromURL() {
        StrictMode();
        try{
            Bundle bundle=getIntent().getExtras();
            String photo=bundle.getString("photo");
            String imgURL="http://10.0.2.2:3000/images/profile/"+photo;
            URL url=new URL(imgURL);
            ivProfile.setImageBitmap(BitmapFactory.decodeStream((InputStream)url.getContent()));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
    ImageListener imageListener=new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private final SensorEventListener lightSensorListener
            = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub


        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                TvRLight.setText("LIGHT: " + event.values[0]);
            }
        }
    };

    @Override
    protected void onStart(){
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiver,intentFilter);
    }
    @Override
    protected void onStop(){
        super.onStop();

        unregisterReceiver(broadcastReceiver);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.nav_map:
                Toast.makeText(this, "Update Profile",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NurseActivity.this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Logout",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(NurseActivity.this, LoginActivity.class);
                startActivity(it);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
