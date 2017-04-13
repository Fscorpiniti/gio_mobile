package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import untref.tesis.gio.domain.LoginData;
import untref.tesis.gio.domain.LoginResponse;

public interface LoginApiService {

    @POST("login")
    Observable<LoginResponse> login(@Body LoginData loginData);

}
