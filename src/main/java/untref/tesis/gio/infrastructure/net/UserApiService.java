package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.infrastructure.response.UserResponse;

public interface UserApiService {

    @POST("users")
    Observable<UserResponse> create(@Body CreateUserData createUserData);

    @GET("users/{ownerId}")
    Observable<UserResponse> findById(@Path("ownerId") Integer ownerId,
                                      @Header("auth_token") String authToken);

}
