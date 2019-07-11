package api;

import java.util.List;

import model.LoginSignupResponse;
import model.Patients;
import model.USER;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface User {
    @Multipart
    @GET("patients")
    Call<List<Patients>> getAllPatients();



}
