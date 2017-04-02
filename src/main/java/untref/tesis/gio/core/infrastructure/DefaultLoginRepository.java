package untref.tesis.gio.core.infrastructure;

import io.reactivex.Observable;
import untref.tesis.gio.core.domain.LoginData;
import untref.tesis.gio.core.domain.LoginRepository;
import untref.tesis.gio.core.domain.User;
import untref.tesis.gio.core.infrastructure.datasource.LoginDataStore;

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
