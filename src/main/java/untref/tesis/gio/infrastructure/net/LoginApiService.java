package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.infrastructure.response.LoginResponse;

public interface LoginApiService {

    @POST("login")
    Observable<Response<LoginResponse>> login(@Body LoginData loginData);

}
