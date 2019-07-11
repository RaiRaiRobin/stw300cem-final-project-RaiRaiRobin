package com.example.finalandroidassignmentproject;

import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import Interface_API.USER_INTERFACE;
import model.LoginSignupResponse;
import retrofit2.Call;
import retrofit2.Response;

import static com.example.finalandroidassignmentproject.R.id.tvtEmail;

public class NurseActivity extends AppCompatActivity {
    CarouselView carouselView;
    private DrawerLayout drawer;
    private ImageView ivProfile;
    private TextView TvRLight,TvLight;


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
}
