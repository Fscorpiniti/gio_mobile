package untref.tesis.gio.infrastructure.datasource;


import io.reactivex.Observable;
import retrofit2.Response;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.entity.UserEconomy;
import untref.tesis.gio.domain.entity.UserLogged;
import untref.tesis.gio.infrastructure.net.LoginApiService;
import untref.tesis.gio.infrastructure.response.LoginResponse;

public class ServerLoginDataStore implements LoginDataStore {

    public static final String AUTH_TOKEN = "auth_token";
    private LoginApiService loginApiService;

    public ServerLoginDataStore(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    @Override
    public Observable<UserLogged> login(final LoginData loginData) {
        return loginApiService.login(loginData).map(response -> buildUserLogged(response));
    }

    private UserLogged buildUserLogged(Response<LoginResponse> response) {
        return new UserLogged(buildUser(response), response.headers().get(AUTH_TOKEN));
    }

    private User buildUser(Response<LoginResponse> response) {
        return new User(response.body().getId(), response.body().getEmail(),
                response.body().getName(), buildUserEconomy(response));
    }

    private UserEconomy buildUserEconomy(Response<LoginResponse> response) {
        return new UserEconomy(response.body().getUserEconomyResponse().getCoins());
    }

}
