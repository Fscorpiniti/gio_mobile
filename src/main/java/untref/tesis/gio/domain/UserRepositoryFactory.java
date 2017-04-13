package untref.tesis.gio.domain;

import untref.tesis.gio.infrastructure.DefaultUserRepository;
import untref.tesis.gio.infrastructure.datasource.ServerUserDataStore;
import untref.tesis.gio.infrastructure.datasource.UserDataStore;
import untref.tesis.gio.infrastructure.net.ApiService;
import untref.tesis.gio.infrastructure.net.CreateUserApiService;

public class UserRepositoryFactory {

    public static UserRepository build() {
        return new DefaultUserRepository(buildUserDataStore());
    }

    private static UserDataStore buildUserDataStore() {
        return new ServerUserDataStore(ApiService.retrofit.create(CreateUserApiService.class));
    }

}
