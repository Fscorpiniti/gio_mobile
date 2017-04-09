package untref.tesis.gio.core.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import untref.tesis.gio.core.domain.CreateUserData;
import untref.tesis.gio.core.domain.CreateUserResponse;

public interface CreateUserApiService {

    @POST("users")
    Observable<CreateUserResponse> create(@Body CreateUserData createUserData);

}