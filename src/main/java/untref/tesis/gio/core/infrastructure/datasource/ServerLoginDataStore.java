package untref.tesis.gio.core.infrastructure.datasource;


import io.reactivex.Observable;
import untref.tesis.gio.core.domain.LoginData;
import untref.tesis.gio.core.domain.User;
import untref.tesis.gio.core.infrastructure.net.LoginApiService;

public class ServerLoginDataStore implements LoginDataStore {

    private LoginApiService loginApiService;

    public ServerLoginDataStore(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    @Override
    public Observable<User> login(final LoginData loginData) {
        return loginApiService.login(loginData).map(data -> new User(data.getId(), data.getEmail(),
                data.getName()));
    }

}
