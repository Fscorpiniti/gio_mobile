package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import untref.tesis.gio.domain.CreateUserData;
import untref.tesis.gio.infrastructure.CreateUserResponse;

public interface CreateUserApiService {

    @POST("users")
    Observable<CreateUserResponse> create(@Body CreateUserData createUserData);

}
