package untref.tesis.gio.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.entity.UserEconomy;
import untref.tesis.gio.infrastructure.net.CreateUserApiService;

public class ServerUserDataStore implements UserDataStore {

    private CreateUserApiService createUserApiService;

    public ServerUserDataStore(CreateUserApiService createUserApiService) {
        this.createUserApiService = createUserApiService;
    }

    @Override
    public Observable<User> add(CreateUserData createUserData) {
        return this.createUserApiService.create(createUserData).map(data -> new User(data.getId(),
                data.getEmail(), data.getName(), new UserEconomy(data.getUserEconomyResponse().getCoins())));
    }
}
