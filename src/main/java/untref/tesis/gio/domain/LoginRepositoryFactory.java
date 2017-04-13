package untref.tesis.gio.domain;

import untref.tesis.gio.infrastructure.net.ApiService;
import untref.tesis.gio.infrastructure.net.LoginApiService;
import untref.tesis.gio.infrastructure.DefaultLoginRepository;
import untref.tesis.gio.infrastructure.datasource.LoginDataStore;
import untref.tesis.gio.infrastructure.datasource.ServerLoginDataStore;

public class LoginRepositoryFactory {

    public static LoginRepository build() {
        return new DefaultLoginRepository(buildLoginDataStore());
    }

    private static LoginDataStore buildLoginDataStore() {
        return new ServerLoginDataStore(ApiService.retrofit.create(LoginApiService.class));
    }
}
