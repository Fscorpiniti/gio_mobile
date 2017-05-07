package untref.tesis.gio.infrastructure.datasource;


import io.reactivex.Observable;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.entity.UserEconomy;
import untref.tesis.gio.infrastructure.net.LoginApiService;

public class ServerLoginDataStore implements LoginDataStore {

    private LoginApiService loginApiService;

    public ServerLoginDataStore(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    @Override
    public Observable<User> login(final LoginData loginData) {
        return loginApiService.login(loginData).map(response ->
                new User(response.getId(), response.getEmail(),
                response.getName(), new UserEconomy(response.getUserEconomyResponse().getCoins())));
    }

}
