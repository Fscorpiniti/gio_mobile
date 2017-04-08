package untref.tesis.gio.core.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.core.domain.CreateUserData;
import untref.tesis.gio.core.domain.User;
import untref.tesis.gio.core.infrastructure.net.CreateUserApiService;

public class ServerUserDataStore implements UserDataStore {

    private CreateUserApiService createUserApiService;

    public ServerUserDataStore(CreateUserApiService createUserApiService) {
        this.createUserApiService = createUserApiService;
    }

    @Override
    public Observable<User> add(CreateUserData createUserData) {
        return this.createUserApiService.create(createUserData).map(data -> new User(data.getId(),
                data.getEmail(), data.getName()));
    }
}
