package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.infrastructure.response.CreateUserResponse;

public interface CreateUserApiService {

    @POST("users")
    Observable<CreateUserResponse> create(@Body CreateUserData createUserData);

}
