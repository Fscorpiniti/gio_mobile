package untref.tesis.gio.core.infrastructure;

import io.reactivex.Observable;
import untref.tesis.gio.core.domain.CreateUserData;
import untref.tesis.gio.core.domain.User;
import untref.tesis.gio.core.domain.UserRepository;
import untref.tesis.gio.core.infrastructure.datasource.UserDataStore;


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
