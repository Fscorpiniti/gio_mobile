package untref.tesis.gio.infrastructure;

import io.reactivex.Observable;
import untref.tesis.gio.domain.CreateUserData;
import untref.tesis.gio.domain.User;
import untref.tesis.gio.domain.UserRepository;
import untref.tesis.gio.infrastructure.datasource.UserDataStore;


public class DefaultUserRepository implements UserRepository {

    private UserDataStore userDataStore;

    public DefaultUserRepository(UserDataStore userDataStore) {
        this.userDataStore = userDataStore;
    }

    @Override
    public Observable<User> add(CreateUserData createUserData) {
        return userDataStore.add(createUserData);
    }
}
