package untref.tesis.gio.core.domain;

import untref.tesis.gio.core.infrastructure.DefaultUserRepository;
import untref.tesis.gio.core.infrastructure.datasource.ServerUserDataStore;
import untref.tesis.gio.core.infrastructure.datasource.UserDataStore;
import untref.tesis.gio.core.infrastructure.net.ApiService;
import untref.tesis.gio.core.infrastructure.net.CreateUserApiService;

public class UserRepositoryFactory {

    public static UserRepository build() {
        return new DefaultUserRepository(buildUserDataStore());
    }

    private static UserDataStore buildUserDataStore() {
        return new ServerUserDataStore(ApiService.retrofit.create(CreateUserApiService.class));
    }

}
