package untref.tesis.gio.infrastructure;

import io.reactivex.Observable;
import untref.tesis.gio.domain.LoginData;
import untref.tesis.gio.domain.LoginRepository;
import untref.tesis.gio.domain.User;
import untref.tesis.gio.infrastructure.datasource.LoginDataStore;

public class DefaultLoginRepository implements LoginRepository {

    private LoginDataStore loginDataStore;

    public DefaultLoginRepository(LoginDataStore loginDataStore) {
        this.loginDataStore = loginDataStore;
    }

    @Override
    public Observable<User> login(LoginData loginData) {
        return loginDataStore.login(loginData);
    }

}
