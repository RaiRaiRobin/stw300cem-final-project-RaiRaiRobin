package Interface_API;

import model.ImageResponse;
import model.LoginSignupResponse;
import model.USER;
import model.info;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface USER_INTERFACE {

    @POST("/user/register/userFormData")
    Call<Void> registerUser(@Body info info);

    @Multipart
    @POST("user/register/userPhoto")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @POST("user/login")
    Call<LoginSignupResponse> loginUser(@Body USER user);
}
