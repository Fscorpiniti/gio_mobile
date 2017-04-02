package untref.tesis.gio.infrastructure.net;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;
import untref.tesis.gio.infrastructure.domain.UserResponse;

public interface LoginApiService {

    @POST("login")
    Call<UserResponse> login(@Query("email") String email, @Query("password") String password);

}
