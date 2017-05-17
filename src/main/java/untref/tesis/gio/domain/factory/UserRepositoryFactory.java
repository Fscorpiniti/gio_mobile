package untref.tesis.gio.domain.factory;

import untref.tesis.gio.domain.repository.UserRepository;
import untref.tesis.gio.infrastructure.repository.DefaultUserRepository;
import untref.tesis.gio.infrastructure.datasource.ServerUserDataStore;
import untref.tesis.gio.infrastructure.datasource.UserDataStore;
import untref.tesis.gio.infrastructure.net.ApiService;
import untref.tesis.gio.infrastructure.net.UserApiService;

public class UserRepositoryFactory {

    public static UserRepository build() {
        return new DefaultUserRepository(buildUserDataStore());
    }

    private static UserDataStore buildUserDataStore() {
        return new ServerUserDataStore(ApiService.retrofit.create(UserApiService.class));
    }

}
