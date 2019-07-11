package Interface_API;

import java.util.List;

import model.Patients;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Patient_Interface {
    @GET("admin/patients/listt")
    Call<List<Patients>> getpatient();
}
