package untref.tesis.gio.core.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import untref.tesis.gio.core.domain.LoginData;
import untref.tesis.gio.core.domain.LoginResponse;

public interface LoginApiService {

    @POST("login")
    Observable<LoginResponse> login(@Body LoginData loginData);

}
