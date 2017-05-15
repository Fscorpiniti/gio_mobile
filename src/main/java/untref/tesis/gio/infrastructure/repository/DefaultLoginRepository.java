package untref.tesis.gio.infrastructure.repository;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.domain.entity.UserLogged;
import untref.tesis.gio.domain.repository.LoginRepository;
import untref.tesis.gio.infrastructure.datasource.LoginDataStore;

public class DefaultLoginRepository implements LoginRepository {

    private LoginDataStore loginDataStore;

    public DefaultLoginRepository(LoginDataStore loginDataStore) {
        this.loginDataStore = loginDataStore;
    }

    @Override
    public Observable<UserLogged> login(LoginData loginData) {
        return loginDataStore.login(loginData);
    }

}
