package untref.tesis.gio.infrastructure.repository;

import untref.tesis.gio.core.domain.LoginRepository;
import untref.tesis.gio.infrastructure.repository.datasource.LoginDataStore;

public class DefaultLoginRepository implements LoginRepository {

    private LoginDataStore loginDataStore;

    public DefaultLoginRepository(LoginDataStore loginDataStore) {
        this.loginDataStore = loginDataStore;
    }

    @Override
    public void login(String email, String password) {
        loginDataStore.login(email, password);
    }

}
