package untref.tesis.gio.core.domain;

import untref.tesis.gio.core.infrastructure.net.ApiService;
import untref.tesis.gio.core.infrastructure.net.LoginApiService;
import untref.tesis.gio.core.infrastructure.DefaultLoginRepository;
import untref.tesis.gio.core.infrastructure.datasource.LoginDataStore;
import untref.tesis.gio.core.infrastructure.datasource.ServerLoginDataStore;

public class LoginRepositoryFactory {

    public static LoginRepository createRepository() {
        return new DefaultLoginRepository(buildLoginDataStore());
    }

    private static LoginDataStore buildLoginDataStore() {
        return new ServerLoginDataStore(ApiService.retrofit.create(LoginApiService.class));
    }
}
