package untref.tesis.gio.infrastructure.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApiService {

    @POST("login")
    void login(@Query("email") String email, @Query("password") String password);

}
