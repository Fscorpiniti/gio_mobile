package untref.tesis.gio.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.entity.UserEconomy;
import untref.tesis.gio.infrastructure.net.UserApiService;

public class ServerUserDataStore implements UserDataStore {

    private UserApiService userApiService;

    public ServerUserDataStore(UserApiService userApiService) {
        this.userApiService = userApiService;
    }

    @Override
    public Observable<User> add(CreateUserData createUserData) {
        return this.userApiService.create(createUserData).map(data -> new User(data.getId(),
                data.getEmail(), data.getName(), new UserEconomy(data.getUserEconomyResponse().getCoins())));
    }

    @Override
    public Observable<User> findById(Integer ownerId, String authToken) {
        return this.userApiService.findById(ownerId, authToken).map(data -> new User(data.getId(),
                data.getEmail(), data.getName(), new UserEconomy(data.getUserEconomyResponse().getCoins())));
    }
}
