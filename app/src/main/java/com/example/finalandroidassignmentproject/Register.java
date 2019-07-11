package com.example.finalandroidassignmentproject;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import Interface_API.USER_INTERFACE;
import model.ImageResponse;
import model.info;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Register extends AppCompatActivity implements View.OnClickListener{
    EditText etFname,etMname,etLname,etDob,etPassword,etPhone,etEmail,etRpassword,etAddress, etGender;
    private Button btn_reg;
    public static final String URL="http://192.168.0.106:3000/";
    private Retrofit retrofit;
    private USER_INTERFACE user_interface;
    private Api_Connection api_connection;



    TextView tvDOB;
    private ImageView imgProfile;
    String imagePath;
    Button btn_exit;


    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        api_connection = new Api_Connection();
        init();
        getConnected();

    }
    private void init() {

        etFname=findViewById(R.id.etFname);
        etMname=findViewById(R.id.etMname);
        etLname=findViewById(R.id.etLname);
        etDob=findViewById(R.id.etDob);
        etGender=findViewById(R.id.etGender);
        etAddress=findViewById(R.id.etAddress);
        etPhone=findViewById(R.id.etPhone);
        etPassword=findViewById(R.id.etPassword);
        etRpassword=findViewById(R.id.etRpassword);
        etEmail=findViewById(R.id.etEmail);

        btn_reg=findViewById(R.id.btn_reg);
        imgProfile = findViewById(R.id.imgProfile);
        imgProfile.setOnClickListener(this);
        btn_reg.setOnClickListener(this);

    }

    private void getConnected() {

        retrofit=api_connection.getRetrofit();
        user_interface=api_connection.getUser_interface();
    }





    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_reg){

            info data=new info(etFname.getText().toString(),etMname.getText().toString(),etLname.getText().toString(),etGender.getText().toString(),etAddress.getText().toString(),etDob.getText().toString(),etPhone.getText().toString(),etEmail.getText().toString(),etPassword.getText().toString());
        RegisterUser(data);
        }
//        if (v.getId()==R.id.imgProfile){
//
//            BrowseImage();

    }






//        btn_exit=(Button)findViewById(R.id.btn_exit);
//        builder = new AlertDialog.Builder(this);

//        tvDOB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadCalendar();
//            }
//        });

//        imgProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BrowseImage();
//            }
//        });


//
//        btn_exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                builder.setIcon(R.drawable.ic_exit_to_app_black_24dp);
//                builder.setMessage("Do you want to close this Application?")
//                        .setCancelable(false)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//                                finish();
//                                Toast.makeText(getApplicationContext(),"You clicked Yes",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                                Toast.makeText(getApplicationContext(),"You clicked No",
//                                        Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//                AlertDialog alert = builder.create();
//                alert.setTitle("My Title");
//                alert.show();
//            }
//        });



//    private void loadCalendar(){
//        final Calendar c = Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                String date = "Month/Day/Year :" + month + "/" + dayOfMonth + "/" + year;
//                tvDOB.setText(date);
//            }
//        },year,month,day);
//        datePickerDialog.show();
//    }

//    private void BrowseImage(){
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent, 0);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK){
//            if (data == null){
//                Toast.makeText(this, "Please Select an image", Toast.LENGTH_SHORT).show();
//            }
//        }
//        Uri uri = data.getData();
//        imagePath = getRealPathFromUri(uri);
//        previewImage(imagePath);
//    }
//    private String getRealPathFromUri(Uri uri){
//        String[] projection = {MediaStore.Images.Media.DATA};
//        CursorLoader loader = new CursorLoader(getApplicationContext(), uri, projection, null,
//                null, null);
//        Cursor cursor = loader.loadInBackground();
//        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//        String result = cursor.getString(colIndex);
//        cursor.close();
//        return result;
//    }
//    private void previewImage(String imagePath){
//
//        File imgFile = new File(imagePath);
//        if(imgFile.exists()){
//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//            imgProfile.setImageBitmap(myBitmap);
//        }
//
//    }




    private void RegisterUser(info info){
        Call<Void> call=user_interface.registerUser(info);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(Register.this, "User Registered successfully", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Register.this, "Cannot load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void StrictMode(){
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//    }
//
//    private void SaveImageOnly(){
//        File file=new File(imagePath);
//        RequestBody requestBody=RequestBody.create(MediaType.parse("multipart/form-data"),file);
//        MultipartBody.Part body= MultipartBody.Part.createFormData("UserPhoto",file.getName(),requestBody);
//
////        USER_INTERFACE user_interface=Api_Connection.getInstance().create(USER_INTERFACE.class);
//        Call<ImageResponse> responseBodyCall= (Call<ImageResponse>) USER_INTERFACE.uploadImage(body);
//
//
//
//        StrictMode();
//
//        try{
//            Response<ImageResponse> imageResponseResponse=responseBodyCall.execute();
//            String UserPhoto=imageResponseResponse.body().getFilename();
//            Toast.makeText(this, UserPhoto, Toast.LENGTH_SHORT).show();
//        }
//        catch (IOException e){
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//          e.printStackTrace();
//        }
//
//    }
//
//    private void  Save(){
//        SaveImageOnly();
//
//    }


}

