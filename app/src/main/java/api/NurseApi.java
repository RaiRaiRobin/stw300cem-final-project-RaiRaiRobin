package api;

import java.util.List;

import model.Patients;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;

public interface NurseApi {
    @Multipart
    @GET("nurses")
    Call<List<Patients>> getAllPatients();
}
