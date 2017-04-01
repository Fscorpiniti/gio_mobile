package untref.tesis.gio.infrastructure.domain;

import untref.tesis.gio.infrastructure.net.ApiService;
import untref.tesis.gio.infrastructure.net.LoginApiService;
import untref.tesis.gio.infrastructure.repository.DefaultLoginRepository;
import untref.tesis.gio.infrastructure.repository.datasource.LoginDataStore;
import untref.tesis.gio.infrastructure.repository.datasource.ServerLoginDataStore;

public class LoginRepositoryFactory {

    public static LoginRepository createRepository() {
        return new DefaultLoginRepository(buildLoginDataStore());
    }

    private static LoginDataStore buildLoginDataStore() {
        return new ServerLoginDataStore(ApiService.retrofit.create(LoginApiService.class));
    }
}
